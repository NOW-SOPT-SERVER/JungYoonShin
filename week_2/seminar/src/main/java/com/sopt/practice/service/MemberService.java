package com.sopt.practice.service;

import com.sopt.practice.domain.Member;
import com.sopt.practice.repository.MemberRepository;
import com.sopt.practice.service.dto.MemberCreateRequest;
import com.sopt.practice.service.dto.MemberCreateResponse;
import com.sopt.practice.service.dto.MemberDetailResponse;
import com.sopt.practice.service.dto.MemberListResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional   //DB 반영을 위한 어노테이션(수정사항 등 발생시)
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
}
