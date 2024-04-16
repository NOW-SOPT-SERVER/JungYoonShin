package com.sopt.practice.controller;

import com.sopt.practice.domain.Part;
import com.sopt.practice.repository.MemberRepository;
import com.sopt.practice.service.MemberService;
import com.sopt.practice.service.dto.MemberCreateResponse;
import com.sopt.practice.settings.ApiTest;
import io.restassured.RestAssured;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

public class MemberControllerTest extends ApiTest {

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberRepository memberRepository;

    @Nested   //중첩 테스트 할 수 있도록 도와줌
    @DisplayName("멤버 생성 테스트")
    public class CreateMember {

        @Test
        @DisplayName("요청 성공 테스트")
        public void createMemberSuccess() throws Exception {
            //given
            final var request = new MemberCreateResponse(
                    "신정윤",
                    Part.SERVER,
                    24
            );

            //when
            final var response = RestAssured
                    .given()
                    .log().all()
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .body(request)
                    .when()
                    .post("/api/v1/member")
                    .then().log().all().extract();

            //then
            Assertions.assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
        }
    }
}
