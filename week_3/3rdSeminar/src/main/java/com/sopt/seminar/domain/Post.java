package com.sopt.seminar.domain;

import com.sopt.seminar.service.dto.PostCreateRequest;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;
import static lombok.AccessLevel.PROTECTED;

@Entity
@Getter
@NoArgsConstructor(access= PROTECTED)
public class Post {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String title;

    private String content;

    @ManyToOne(fetch = LAZY)
    private Blog blog;

    @Builder
    private Post(String title, String content, Blog blog) {
        this.title = title;
        this.content = content;
        this.blog = blog;
    }

    public static Post createPost(PostCreateRequest postCreateRequest, Blog blog) {
        return Post.builder()
                .title(postCreateRequest.title())
                .content(postCreateRequest.content())
                .blog(blog)
                .build();
    }
}
