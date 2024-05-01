package com.sopt.seminar.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public record SuccessStatusResponse<T> (
        int status,
        String message,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        T data
) {
    public static <T> SuccessStatusResponse of(SuccessMessage successMesage, T data) {
        return new SuccessStatusResponse(successMesage.getStatus(), successMesage.getMessage(), data);
    }

    public static SuccessStatusResponse of(SuccessMessage successMesage) {
        return new SuccessStatusResponse(successMesage.getStatus(), successMesage.getMessage(), null);
    }
}
