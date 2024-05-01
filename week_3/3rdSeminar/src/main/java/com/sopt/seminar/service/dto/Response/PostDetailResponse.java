package com.sopt.seminar.service.dto.Response;

import com.sopt.seminar.domain.Post;

public record PostDetailResponse(
        String title,
        String content
) {
    public static PostDetailResponse of(Post post) {
        return new PostDetailResponse(post.getTitle(), post.getContent());
    }
}
