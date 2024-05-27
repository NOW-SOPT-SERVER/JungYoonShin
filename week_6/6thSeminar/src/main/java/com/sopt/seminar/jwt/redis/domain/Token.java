package com.sopt.seminar.jwt.redis.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

@RedisHash(value = "refreshToken", timeToLive = 24 * 60 * 60 * 1000L * 14)
@Builder
@Getter
@AllArgsConstructor
public class Token {

    @Id
    private Long id;

    @Indexed
    private String refreshToken;

    public static Token of(
            final Long id,
            final String refreshToken
    ) {
        return Token.builder()
                .id(id)
                .refreshToken(refreshToken)
                .build();
    }
}
