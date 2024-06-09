package com.sopt.seminar.service.dto.Request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Post Create request")
public record PostCreateRequest(

        @Schema(description = "글 제목", example = "블로그 제목 테스트")
        @NotBlank(message = "제목은 필수 값입니다.")
        String title,

        @Schema(description = "글 내용", example = "Hello World!")
        @Size(min = 1, max = 50, message = "내용은 1글자 이상 50글자 이하만 가능합니다.")
        String content
) {
}
