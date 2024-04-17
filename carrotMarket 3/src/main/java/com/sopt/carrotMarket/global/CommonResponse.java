package com.sopt.carrotMarket.global;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CommonResponse<T> {
    private final int code;
    private final HttpStatus httpStatus;
    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final T data;

    @Builder
    public CommonResponse(int code, HttpStatus httpStatus, T data) {
        this.code = code;
        this.httpStatus = httpStatus;
        this.message = "요청에 성공했습니다";
        this.data = data;
    }
}