package com.sopt.seminar.controller;


import com.sopt.seminar.common.dto.SuccessMessage;
import com.sopt.seminar.common.dto.SuccessStatusResponse;
import com.sopt.seminar.common.jwt.PrincipalHandler;
import com.sopt.seminar.service.BlogService;
import com.sopt.seminar.service.dto.BlogCreateRequset;
import com.sopt.seminar.service.dto.BlogTitleUdateRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;
    private final PrincipalHandler principalHandler;

    @PostMapping("/blog")
    public ResponseEntity createBlog(
            @ModelAttribute BlogCreateRequset blogCreateRequest
    ) {
        return ResponseEntity.created(URI.create(blogService.create(
                principalHandler.getUserIdFromPrincipal(), blogCreateRequest))).build();
    }

    @PatchMapping("/blog/{blogId}/title")
    public ResponseEntity updateBlogTitle(
            @PathVariable Long blogId,
            @Valid @RequestBody BlogTitleUdateRequest blogTitleUdateRequest
    ) {
        blogService.updateTitle(blogId, blogTitleUdateRequest);
        return ResponseEntity.noContent().build();
    }
}
