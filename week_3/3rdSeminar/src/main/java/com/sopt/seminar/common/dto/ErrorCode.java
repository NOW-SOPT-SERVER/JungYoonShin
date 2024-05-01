package com.sopt.seminar.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    MEMBER_NOT_FOUND(HttpStatus.NO_CONTENT.value(), 1001, "ID에 해당하는 사용자가 존재하지 않습니다."),

    // 블로그 관련 에러 200번대
    BLOG_NOT_FOUND(HttpStatus.NO_CONTENT.value(), 2001, "ID에 해당하는 블로그가 존재하지 않습니다."),
    NOT_BLOG_OWNER(HttpStatus.BAD_REQUEST.value(), 2002, "해당 블로그의 소유자가 아니므로 작성 권한이 없습니다."),

    POST_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), 3001, "ID에 해당하는 작성된 글이 존재하지 않습니다."),

    INVALID_VALUE(HttpStatus.BAD_REQUEST.value(), 9001, "잘못된 입력값입니다.");

    private final int httpStatus;
    private final int code;
    private final String message;
}
