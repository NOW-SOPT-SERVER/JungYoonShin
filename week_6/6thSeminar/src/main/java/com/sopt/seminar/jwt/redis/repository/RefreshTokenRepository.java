package com.sopt.seminar.jwt.redis.repository;

import com.sopt.seminar.jwt.redis.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Long> {

    Optional<RefreshToken> findByRefreshToken(final String refreshToken);
    Optional<RefreshToken> findById(final Long id);

}
