package com.sopt.seminar.jwt.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sopt.seminar.jwt.JwtTokenProvider;
import com.sopt.seminar.jwt.TokenInfo;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;


@Component
@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        //atk, rtk 발급
        response.setContentType(APPLICATION_JSON_VALUE);

        //refreshToken 업데이트(나중에 건드리기..)
//        member.updateRefreshToken(tokenInfo.getRefreshToken());

        new ObjectMapper().writeValue(
                response.getWriter(),
                TokenInfo.of(jwtTokenProvider.issueAccessToken(authentication), jwtTokenProvider.issueRefreshToken(authentication))
        );
    }
}
