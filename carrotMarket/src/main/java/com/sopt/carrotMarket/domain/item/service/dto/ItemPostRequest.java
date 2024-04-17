package com.sopt.carrotMarket.domain.item.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ItemPostRequest(
        @NotBlank(message = "제목을 필수입니다.")
        String title,

        @NotBlank(message = "설명을 필수입니다.")
        String description,
        int price,

        @NotNull(message = "카테고리는 필수입니다.")
        int category
) {
}
