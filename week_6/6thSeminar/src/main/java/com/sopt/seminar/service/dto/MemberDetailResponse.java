package com.sopt.seminar.service.dto;

import com.sopt.seminar.domain.Member;
import com.sopt.seminar.domain.Part;

public record MemberDetailResponse(
        String name,
        Part part,
        int age


) {
    public static MemberDetailResponse of(Member member) {
        return new MemberDetailResponse(member.getName(), member.getPart(), member.getAge());
    }
}
