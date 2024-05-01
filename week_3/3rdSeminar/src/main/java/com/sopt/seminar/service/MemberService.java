package com.sopt.seminar.service;

import com.sopt.seminar.common.dto.ErrorCode;
import com.sopt.seminar.domain.Member;
import com.sopt.seminar.exception.NotFoundException;
import com.sopt.seminar.repository.MemberRepository;
import com.sopt.seminar.service.dto.Request.MemberCreateRequest;
import com.sopt.seminar.service.dto.Response.MemberCreateResponse;
import com.sopt.seminar.service.dto.Response.MemberDetailResponse;
import com.sopt.seminar.service.dto.Response.MemberListResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional //DB 반영을 위한 어노테이션(수정사항 등 발생시)
    public MemberCreateResponse createMember(
            final MemberCreateRequest memberCreateDto  //인자로 들어오는 값의 불변성?을 보장하기 위해 final을 붙임
    ) {
        Member member = Member.create(memberCreateDto.name(), memberCreateDto.part(), memberCreateDto.age());
        memberRepository.save(member);
        return MemberCreateResponse.of(member);
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
                () -> new NotFoundException(ErrorCode.MEMBER_NOT_FOUND)
        );
    }
}
