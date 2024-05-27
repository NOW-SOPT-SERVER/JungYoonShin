package com.sopt.seminar.service;

import com.sopt.seminar.common.dto.ErrorMessage;
import com.sopt.seminar.common.jwt.JwtTokenProvider;
import com.sopt.seminar.common.jwt.UserAuthentication;
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
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public UserJoinResponse createMember(
            MemberCreateRequest memberCreate
    ) {
        Member member = memberRepository.save(
                Member.create(memberCreate.name(), memberCreate.part(), memberCreate.age())
        );

        Long memberId = member.getId();
        UserAuthentication userAuthentication = UserAuthentication.createUserAuthentication(memberId);

        return UserJoinResponse.of(
                jwtTokenProvider.issueAccessToken(userAuthentication),
                jwtTokenProvider.issueRefreshToken(userAuthentication),
                memberId.toString()
        );
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
                .orElseThrow(()-> new EntityNotFoundException("ID에 해당하는 사용자가 존재하지 않습니다."));
    }

    public Member findById(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND)
        );
    }
}
