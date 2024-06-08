package com.sopt.seminar.controller;

import com.sopt.seminar.common.dto.SuccessStatusResponse;
import com.sopt.seminar.service.PostService;
import com.sopt.seminar.service.dto.Request.PostCreateRequest;
import com.sopt.seminar.service.dto.Response.PostDetailResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.sopt.seminar.common.dto.SuccessMessage.POST_CREATE_SUCCESS;
import static com.sopt.seminar.common.dto.SuccessMessage.SINGLE_POST_FIND_SUCCESS;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PostController implements PostControllerSwagger {

    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity<SuccessStatusResponse> createPost(
            @RequestHeader Long memberId,
            @RequestHeader Long blogId,
            @Valid @RequestBody PostCreateRequest postCreateRequest
    ){
        postService.createPost(memberId, blogId, postCreateRequest);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(SuccessStatusResponse.of(POST_CREATE_SUCCESS));
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<SuccessStatusResponse<PostDetailResponse>> getSinglePost(@PathVariable Long postId) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(SuccessStatusResponse.of(SINGLE_POST_FIND_SUCCESS, postService.getSinglePost(postId)));
    }

}
