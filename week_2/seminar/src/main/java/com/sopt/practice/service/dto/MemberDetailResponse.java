package com.sopt.practice.service.dto;

import com.sopt.practice.domain.Member;
import com.sopt.practice.domain.Part;

public record MemberDetailResponse(
        String name,
        Part part,
        int age


) {
    public static MemberDetailResponse of(Member member) {
        return new MemberDetailResponse(member.getName(), member.getPart(), member.getAge());
    }
}
