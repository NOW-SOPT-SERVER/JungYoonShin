package com.sopt.seminar.service.dto.Response;

import java.util.List;

public record MemberListResponse(
        Integer totalCount,
        List<MemberDetailResponse> memberDetail
) {

    public static MemberListResponse of(List<MemberDetailResponse> memberDetail) {
        return new MemberListResponse(memberDetail.size(), memberDetail);
    }
}