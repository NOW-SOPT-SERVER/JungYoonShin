package com.sopt.practice.unit.member;

import com.sopt.practice.controller.MemberController;
import com.sopt.practice.domain.Member;
import com.sopt.practice.domain.Part;
import com.sopt.practice.service.MemberService;
import com.sopt.practice.service.dto.MemberDetailResponse;
import com.sopt.practice.service.dto.MemberListResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import java.util.List;

@WebMvcTest(MemberController.class)
@MockBean(JpaMetamodelMappingContext.class)
public class MemberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MemberService memberService;

    @Test
    @DisplayName("GET - 멤버 목록 조회 컨트롤러 확인")
    public void getMemberList() throws Exception {

        //given
        Member memberA = Member.create("신정윤", Part.SERVER, 24);
        Member memberB = Member.create("아무개", Part.SERVER, 22);

        MemberDetailResponse memberFindDto = MemberDetailResponse.of(memberA);
        MemberListResponse memberListDto = MemberListResponse.of(List.of(memberFindDto));

        given(memberService.getMemberList()).willReturn(memberListDto);

        //when & then
        mockMvc.perform(get("/api/v1/member"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.memberDetail[0].name").value(memberFindDto.name()));
    }
}
