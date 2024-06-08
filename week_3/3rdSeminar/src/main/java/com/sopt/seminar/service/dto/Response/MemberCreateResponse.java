package com.sopt.seminar.service.dto.Response;

import com.sopt.seminar.domain.Member;

public record MemberCreateResponse(
        Long id
) {
    public static MemberCreateResponse of(Member member) {
        return new MemberCreateResponse(member.getId());
    }
}
