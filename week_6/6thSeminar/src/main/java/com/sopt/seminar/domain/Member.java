package com.sopt.seminar.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    private Part part;

    private int age;

    private String password;

    @Builder
    private Member(String name, Part part, int age, String email, String password) {
        this.name = name;
        this.part = part;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public static Member create(String name, Part part, int age, String email, String password) {
        return Member.builder()
                .name(name)
                .part(part)
                .age(age)
                .email(email)
                .password(password)
                .build();
    }
}
