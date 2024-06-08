package com.sopt.carrotMarket.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    /* 400 BAD_REQUEST : 잘못된 요청 */
    INVALID_ARGUMENT_ERROR(HttpStatus.BAD_REQUEST, 400, "올바르지 않은 파라미터입니다."),
    INVALID_FORMAT_ERROR(HttpStatus.BAD_REQUEST,400, "올바르지 않은 포맷입니다."),
    INVALID_TYPE_ERROR(HttpStatus.BAD_REQUEST, 400, "올바르지 않은 타입입니다."),
    ILLEGAL_ARGUMENT_ERROR(HttpStatus.BAD_REQUEST, 400, "필수 파라미터가 없습니다"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, 500, "서버 오류가 발생했습니다. 잠시 후 다시 시도해주세요."),
    INVALID_HTTP_METHOD(HttpStatus.METHOD_NOT_ALLOWED, 400, "잘못된 Http Method 요청입니다."),


    /* 401 UNAUTHORIZED : 인증되지 않은 사용자 */
    INVALID_AUTH_TOKEN(UNAUTHORIZED,401, "권한 정보가 없는 토큰입니다"),
    UNAUTHORIZED_MEMBER(UNAUTHORIZED,401, "현재 내 계정 정보가 존재하지 않습니다"),

    /* 404 NOT_FOUND : Resource 를 찾을 수 없음 */
    MEMBER_NOT_FOUND(NOT_FOUND,404, "해당 유저 정보를 찾을 수 없습니다"),
    REFRESH_TOKEN_NOT_FOUND(NOT_FOUND, 404,"로그아웃 된 사용자입니다"),

    /* 409 CONFLICT : Resource 의 현재 상태와 충돌. 보통 중복된 데이터 존재 */
    DUPLICATE_RESOURCE(CONFLICT,409, "데이터가 이미 존재합니다"),

    /* 90# : @Valid EXCEPTION */
    INVALID_VALUE(BAD_REQUEST, 901, "잘못된 입력값입니다.");


    private final HttpStatus httpStatus;
    private final int code;
    private final String detail;
}