package com.sopt.seminar.common.dto;

public record SuccessStatusResponse(
        int status,
        String message
) {
    public static SuccessStatusResponse of(SuccessMessage successMesage) {
        return new SuccessStatusResponse(successMesage.getStatus(), successMesage.getMessage());
    }
}
