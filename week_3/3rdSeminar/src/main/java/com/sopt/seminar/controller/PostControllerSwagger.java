package com.sopt.seminar.controller;

import com.sopt.seminar.common.dto.ErrorResponse;
import com.sopt.seminar.common.dto.SuccessStatusResponse;
import com.sopt.seminar.service.dto.Request.PostCreateRequest;
import com.sopt.seminar.service.dto.Response.PostDetailResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@Tag(name = "Posts", description = "블로그 글 API")
public interface PostControllerSwagger {

    @Operation(summary = "글 작성 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "글 등록 성공"),
            @ApiResponse(responseCode = "400", description = "제목과 내용은 필수입니다.",
                    content = {@Content(schema = @Schema(implementation = ErrorResponse.class))})
    })
    ResponseEntity<SuccessStatusResponse> createPost(
            @RequestHeader Long memberId,
            @RequestHeader Long blogId,
            @Valid @RequestBody PostCreateRequest postCreateRequest
    );

    @Operation(summary = "글 조회 API")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "글 조회 성공"),
            @ApiResponse(responseCode = "400", description = "ID에 해당하는 작성된 글이 존재하지 않습니다.",
                    content = {@Content(schema = @Schema(implementation = ErrorResponse.class))})
    })
    ResponseEntity<SuccessStatusResponse<PostDetailResponse>> getSinglePost(@PathVariable Long postId);
}

