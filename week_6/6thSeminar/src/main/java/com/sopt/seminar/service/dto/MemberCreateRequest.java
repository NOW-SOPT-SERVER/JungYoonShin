package com.sopt.seminar.service.dto;

import com.sopt.seminar.domain.Part;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public record MemberCreateRequest(
        String name,
        Part part,
        int age,

        @NotBlank(message = "이메일은 필수 값입니다.")
        String email,

        @NotBlank(message = "비밀번호는 필수 값입니다.")
        String password
) {
}
