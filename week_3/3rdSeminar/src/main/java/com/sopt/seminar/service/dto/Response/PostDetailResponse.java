package com.sopt.seminar.service.dto.Response;

import com.sopt.seminar.domain.Post;
import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Post Detail response")
public record PostDetailResponse(
        @Schema(description = "글 제목", example = "블로그 제목 테스트")
        String title,

        @Schema(description = "글 내용", example = "Hello World!")
        String content
) {
    public static PostDetailResponse of(Post post) {
        return new PostDetailResponse(post.getTitle(), post.getContent());
    }
}
