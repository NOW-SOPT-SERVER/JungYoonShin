package com.sopt.seminar.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BlogCreateRequest(
        @NotBlank(message = "제목은 필수값입니다.")
        String title,

        @Size(min = 1, max = 50, message = "내용은 1글자 이상 50글자 이하만 가능합니다.")
        String description
) {
}
