package com.sopt.practice.service.dto;

import com.sopt.practice.domain.Part;

public record MemberCreateResponse(
        String name,
        Part part,
        int age
) {
}
