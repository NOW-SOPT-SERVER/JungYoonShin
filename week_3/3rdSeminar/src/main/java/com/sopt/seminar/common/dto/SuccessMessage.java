package com.sopt.seminar.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum SuccessMessage {

    BLOG_CREATE_SUCCESS(HttpStatus.CREATED.value(), "블로그 생성이 완료되었습니다."),
    MEMBER_CREATE_SUCCESS(HttpStatus.CREATED.value(), "멤버 생성이 완료되었습니다."),
    MEMBER_FIND_SUCCESS(HttpStatus.OK.value(), "멤버 조회가 완료되었습니다"),
    MEMBER_DELETE_SUCCESS(HttpStatus.OK.value(), "멤버 삭제가 완료되었습니다."),
    POST_CREATE_SUCCESS(HttpStatus.OK.value(), "블로그 글 작성이 완료되었습니다.");


    private final int status;
    private final String message;
}
