package com.sopt.seminar.global;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ApiResponse<T> {
    private final int code;
    private final boolean success;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private final T result;

    @Builder
    public ApiResponse(int code, boolean success, T result) {
        this.code = code;
        this.success = success;
        this.result = result;
    }
}