package com.sopt.practice.unit.member;

import com.sopt.practice.domain.Member;
import com.sopt.practice.domain.Part;
import com.sopt.practice.repository.MemberRepository;
import com.sopt.practice.service.MemberService;
import com.sopt.practice.service.dto.MemberListDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import static org.mockito.BDDMockito.given;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

public class MemberServiceTest {
    @ExtendWith(MockitoExtension.class)

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @DisplayName("멤버 목록 조회 성공")
    @Test
    void getMemberList() {
        //given
        List<Member> memberList = new ArrayList<>();
        Member memberA = Member.create("신정윤", Part.SERVER, 24);
        Member memberB = Member.create("아무개", Part.SERVER, 22);
        memberList.add(memberA);
        memberList.add(memberB);

        given(memberRepository.findAll()).willReturn(memberList);

        // when
        MemberListDto memberListDto = memberService.getMemberList();

        // then
        Assertions.assertThat(memberListDto.memberDetail().size()).isEqualTo(2);
    }

}
