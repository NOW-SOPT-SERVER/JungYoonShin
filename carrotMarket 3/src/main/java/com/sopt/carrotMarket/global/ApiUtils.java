package com.sopt.carrotMarket.global;

import org.springframework.http.HttpStatus;

public class ApiUtils {
    public static <T> CommonResponse<T> success(int code, HttpStatus httpStatus, T result) {
        return new CommonResponse<>(code, httpStatus, result);
    }
}