package com.sopt.seminar.controller;


import com.sopt.seminar.common.dto.SuccessMessage;
import com.sopt.seminar.common.dto.SuccessStatusResponse;
import com.sopt.seminar.service.BlogService;
import com.sopt.seminar.service.dto.Request.BlogCreateRequest;
import com.sopt.seminar.service.dto.Request.BlogTitleUdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<SuccessStatusResponse> createBlog(
            @RequestHeader Long memberId,
            @Valid @RequestBody BlogCreateRequest blogCreateRequest)
    {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location",  blogService.create(memberId, blogCreateRequest))
                .body(SuccessStatusResponse.of(SuccessMessage.BLOG_CREATE_SUCCESS));
    }

    @PatchMapping("/blog/{blogId}/title")
    public ResponseEntity updateBlogTitle(
            @PathVariable Long blogId,
            @Valid @RequestBody BlogTitleUdateRequest blogTitleUdateRequest)
    {
        blogService.updateTitle(blogId, blogTitleUdateRequest);
        return ResponseEntity.noContent().build();
    }
}
