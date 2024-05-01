package com.sopt.seminar.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;

public record SuccessStatusResponse<T> (

        @Schema(description = "상태 코드", nullable = false, example = "200")
        int status,

        @Schema(description = "상태 메세지", nullable = false, example = "성공하였습니다.")
        String message,

        @Schema(description = "데이터", nullable = false)
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
