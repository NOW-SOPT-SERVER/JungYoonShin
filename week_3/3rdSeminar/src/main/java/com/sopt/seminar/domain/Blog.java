package com.sopt.seminar.domain;

import com.sopt.seminar.service.dto.Request.BlogCreateRequest;
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
public class Blog {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @OneToOne(fetch = LAZY)
    private Member member;

    @Column(length = 200)
    private String title;

    private String description;

    @Builder
    private Blog(Member member, String title, String description) {
        this.member = member;
        this.title = title;
        this.description = description;
    }

    public static Blog create(
            Member member,
            BlogCreateRequest blogCreateRequset
    ) {
        return Blog.builder()
                .member(member)
                .title(blogCreateRequset.title())
                .description(blogCreateRequset.description())
                .build();
    }

    public void updateTitle(String title) {
        this.title = title;
    }
}
