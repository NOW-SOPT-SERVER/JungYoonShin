package com.sopt.seminar.service.dto.Request;

import com.sopt.seminar.domain.Part;

public record MemberCreateRequest(
        String name,
        Part part,
        int age
) {
}
