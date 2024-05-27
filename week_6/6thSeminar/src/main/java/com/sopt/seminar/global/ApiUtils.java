package com.sopt.seminar.global;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ApiUtils {
    public static <T> ResponseEntity<ApiResponse<?>> success(HttpStatus status, T result) {
        return ResponseEntity
                .status(status)
                .body(ApiResponse.builder().code(status.value()).success(true).result(result)
                .build());
    }

    public static <T> ResponseEntity<ApiResponse<?>> success(HttpStatus status) {
        return ResponseEntity
                .status(status)
                .body(ApiResponse.builder().code(status.value()).success(true)
                .build());
    }
}