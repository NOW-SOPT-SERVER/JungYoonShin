package com.sopt.seminar.service;

import com.sopt.seminar.common.dto.ErrorCode;
import com.sopt.seminar.domain.Blog;
import com.sopt.seminar.domain.Post;
import com.sopt.seminar.exception.CustomException;
import com.sopt.seminar.exception.NotFoundException;
import com.sopt.seminar.repository.BlogRepository;
import com.sopt.seminar.repository.PostRepository;
import com.sopt.seminar.service.dto.Response.PostDetailResponse;
import com.sopt.seminar.service.dto.Request.PostCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final BlogRepository blogRepository;

    @Transactional
    public void createPost(
            final Long memberId,
            final Long blogId,
            final PostCreateRequest postCreateRequest
    ) {
        Blog blog = blogRepository.findById(blogId).orElseThrow(
                ()-> new NotFoundException(ErrorCode.BLOG_NOT_FOUND)
        );

        if (!memberId.equals(blog.getMember().getId())) {
            throw new CustomException(ErrorCode.NOT_BLOG_OWNER);
        }

        postRepository.save(Post.createPost(postCreateRequest, blog));
    }

    @Transactional(readOnly = true)
    public PostDetailResponse getSinglePost(final Long postId) {
        return PostDetailResponse.of(findPostById(postId));
    }

    public Post findPostById(Long postId) {
        return postRepository.findById(postId).orElseThrow(
                ()-> new NotFoundException(ErrorCode.POST_NOT_FOUND)
        );
    }

    
}
