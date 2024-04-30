package com.sopt.practice.service.dto;

import com.sopt.practice.domain.Part;

public record MemberCreateRequest(
        String name,
        Part part,
        int age
) {
}
