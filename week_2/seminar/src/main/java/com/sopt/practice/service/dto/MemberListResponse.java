package com.sopt.practice.service.dto;

import java.util.List;

public record MemberListResponse(
        List<MemberDetailResponse> memberDetail
) {

    public static MemberListResponse of(List<MemberDetailResponse> memberDetail) {
        return new MemberListResponse(memberDetail);
    }
}
