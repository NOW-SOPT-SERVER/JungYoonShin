package com.sopt.seminar.service;


import com.sopt.seminar.common.dto.ErrorMessage;
import com.sopt.seminar.domain.Blog;
import com.sopt.seminar.domain.Member;
import com.sopt.seminar.exception.NotFoundException;
import com.sopt.seminar.external.S3Service;
import com.sopt.seminar.repository.BlogRepository;
import com.sopt.seminar.service.dto.BlogCreateRequset;
import com.sopt.seminar.service.dto.BlogTitleUdateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final MemberService memberService;

    private final S3Service s3Service;
    private static final String BLOG_S3_UPLOAD_FOLER = "blog/";


    @Transactional
    public String create(Long memberId, BlogCreateRequset createRequest) {
        //member찾기
        Member member = memberService.findById(memberId);
        try {
            Blog blog = blogRepository.save(Blog.create(member, createRequest.title(), createRequest.description(),
                    s3Service.uploadImage(BLOG_S3_UPLOAD_FOLER, createRequest.image())));
            return blog.getId().toString();
        } catch (RuntimeException | IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }


    @Transactional
    public void updateTitle(Long blogId, BlogTitleUdateRequest blogTitleUdateRequest) {
        Blog blog = findById(blogId);
        blog.updateTitle(blogTitleUdateRequest.title());
    }

    public Blog findById(Long blogId) {
        return blogRepository.findById(blogId).orElseThrow(
                () -> new NotFoundException(ErrorMessage.BLOG_NOT_FOUND)
        );
    }
}

