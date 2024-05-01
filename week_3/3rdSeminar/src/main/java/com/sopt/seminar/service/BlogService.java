package com.sopt.seminar.service;


import com.sopt.seminar.common.dto.ErrorCode;
import com.sopt.seminar.domain.Blog;
import com.sopt.seminar.domain.Member;
import com.sopt.seminar.exception.NotFoundException;
import com.sopt.seminar.repository.BlogRepository;
import com.sopt.seminar.service.dto.BlogCreateRequest;
import com.sopt.seminar.service.dto.BlogTitleUdateRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepsitory;
    private final MemberService memberService;

    public String create(Long memberId, BlogCreateRequest blogCreateRequest) {
        //member찾기
        Member member = memberService.findById(memberId);
        Blog blog = blogRepsitory.save(Blog.create(member, blogCreateRequest));
        return blog.getId().toString();
    }


    @Transactional
    public void updateTitle(Long blogId, BlogTitleUdateRequest blogTitleUdateRequest) {
        Blog blog = findById(blogId);
        blog.updateTitle(blogTitleUdateRequest.title());
    }

    public Blog findById(Long blogId) {
        return blogRepsitory.findById(blogId).orElseThrow(
                () -> new NotFoundException(ErrorCode.BLOG_NOT_FOUND)
        );
    }
}

