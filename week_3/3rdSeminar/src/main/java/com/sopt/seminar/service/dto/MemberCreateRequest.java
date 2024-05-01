package com.sopt.seminar.service.dto;

import com.sopt.seminar.domain.Part;

public record MemberCreateRequest(
        String name,
        Part part,
        int age
) {
}
