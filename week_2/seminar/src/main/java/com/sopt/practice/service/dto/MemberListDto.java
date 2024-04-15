package com.sopt.practice.service.dto;

import java.util.List;

public record MemberListDto(
        List<MemberFindDto> memberDetail
) {

    public static MemberListDto of(List<MemberFindDto> memberDetail) {
        return new MemberListDto(memberDetail);
    }
}
