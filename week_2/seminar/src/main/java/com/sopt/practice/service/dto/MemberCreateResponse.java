package com.sopt.practice.service.dto;

import com.sopt.practice.domain.Member;

public record MemberCreateResponse(
        Long id
) {
    public static MemberCreateResponse of(Member member) {
        return new MemberCreateResponse(member.getId());
    }
}
