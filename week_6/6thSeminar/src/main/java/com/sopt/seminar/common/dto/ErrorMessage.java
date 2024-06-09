package com.sopt.seminar.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorMessage {

    MEMBER_NOT_FOUND(HttpStatus.NO_CONTENT.value(), "ID에 해당하는 사용자가 존재하지 않습니다."),
    BLOG_NOT_FOUND(HttpStatus.NO_CONTENT.value(), "ID에 해당하는 블로그가 존재하지 않습니다."),
    JWT_UNAUTHORIZED_EXCEPTION(HttpStatus.UNAUTHORIZED.value(), "사용자의 로그인 검증을 실패했습니다."),
    EXPIRED_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED.value(), "리프레시 토큰이 만료되었습니다. 재로그인해주세요."),
    EXPIRED_ACCESS_TOKEN(HttpStatus.UNAUTHORIZED.value(), "엑세스 토큰이 만료되었습니다. 재발급 받아주세요."),
    MISMATCH_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED.value(), "실제 리프레시 토큰과 일치하지 않습니다. 재로그인해주세요.")
    ;

    private final int status;
    private final String message;
}
