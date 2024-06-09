package com.sopt.seminar.service;

import com.sopt.seminar.common.dto.ErrorMessage;
import com.sopt.seminar.exception.UnauthorizedException;
import com.sopt.seminar.jwt.JwtTokenProvider;
import com.sopt.seminar.jwt.TokenInfo;
import com.sopt.seminar.jwt.UserAuthentication;
import com.sopt.seminar.jwt.redis.domain.RefreshToken;
import com.sopt.seminar.jwt.redis.repository.RefreshTokenRepository;
import com.sopt.seminar.service.dto.UserJoinResponse;
import com.sopt.seminar.domain.Member;
import com.sopt.seminar.exception.NotFoundException;
import com.sopt.seminar.repository.MemberRepository;
import com.sopt.seminar.service.dto.MemberCreateRequest;
import com.sopt.seminar.service.dto.MemberDetailResponse;
import com.sopt.seminar.service.dto.MemberListResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;
    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public UserJoinResponse createMember(
            MemberCreateRequest memberCreate
    ) {
        Member member = memberRepository.save(
                Member.create(
                        memberCreate.name(), memberCreate.part(),
                        memberCreate.age(), memberCreate.email(), memberCreate.password()
                )
        );

        UserAuthentication userAuthentication = UserAuthentication.createUserAuthentication(memberCreate.email());
        TokenInfo token = issueTokenAndStoreRefreshToken(userAuthentication, member.getId());

        return UserJoinResponse.of(token.accessToken(), token.refreshToken());
    }

    public TokenInfo reissue(String refreshToken) {
        jwtTokenProvider.validateToken(refreshToken);
        String userEmail = jwtTokenProvider.getUserFromJwt(refreshToken);
        System.out.println("userEmail = " + userEmail);
        Member member = findMember(userEmail);

        //리프레시 토큰 탈취여부 확인(탈취범이 정상 유저보다 먼저 재발급 받았을 경우 -> 재로그인 유도)
        jwtTokenProvider.matchRefreshToken(refreshToken, findRefreshToken(member.getId()).getRefreshToken());

        UserAuthentication userAuthentication = UserAuthentication.createUserAuthentication(userEmail);
        TokenInfo token = issueTokenAndStoreRefreshToken(userAuthentication, member.getId());

        return token;
    }

    public MemberDetailResponse findMemberById(Long memberId) {
        return MemberDetailResponse.of(memberRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다.")
        ));
    }

    @Transactional
    public void deleteMemberById(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(()-> new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다."));
        memberRepository.delete(member);
    }

    public MemberListResponse getMemberList() {
        List<MemberDetailResponse> memberDetailDtos = null;
        memberDetailDtos = memberRepository.findAll().stream()
                .map(MemberDetailResponse::of)
                .toList();

        return MemberListResponse.of(memberDetailDtos);
    }

    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId)
                .orElseThrow(()-> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND));
    }

    public Member findMember(String email) {
        return memberRepository.findByEmail(email)
                .orElseThrow(()-> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND));
    }

    private RefreshToken findRefreshToken(Long userId) {
        return refreshTokenRepository.findById(userId)
                .orElseThrow(() -> new NotFoundException(ErrorMessage.EXPIRED_REFRESH_TOKEN));
    }

    private TokenInfo issueTokenAndStoreRefreshToken(Authentication authentication, Long userId) {
        TokenInfo issuedToken = jwtTokenProvider.issueToken(authentication);
        RefreshToken refreshToken = RefreshToken.builder()
                        .id(userId)
                        .refreshToken(issuedToken.refreshToken())
                        .build();

        refreshTokenRepository.save(refreshToken);
        return issuedToken;
    }
}