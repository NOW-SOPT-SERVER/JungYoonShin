package com.sopt.seminar.service;

import com.sopt.seminar.common.dto.ErrorCode;
import com.sopt.seminar.domain.Blog;
import com.sopt.seminar.domain.Member;
import com.sopt.seminar.domain.Post;
import com.sopt.seminar.exception.CustomException;
import com.sopt.seminar.exception.NotFoundException;
import com.sopt.seminar.repository.BlogRepository;
import com.sopt.seminar.repository.MemberRepository;
import com.sopt.seminar.repository.PostRepository;
import com.sopt.seminar.service.dto.PostCreateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final MemberRepository memberRepository;
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

        Post.createPost(postCreateRequest, blog);
    }

    
}
