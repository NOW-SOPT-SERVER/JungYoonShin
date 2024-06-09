package com.sopt.seminar.jwt.filter;

import com.sopt.seminar.jwt.UserAuthentication;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@RequiredArgsConstructor
public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        // 사용자가 제공한 인증 정보 추출
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // UsernamePasswordAuthenticationToken 생성(이때 authentication 는 인증 여부를 확인하는 authenticated 값이 false)
        UserAuthentication authentication = UserAuthentication.createUserAuthentication(email, password);

        /**
         * 실제 인증을 수행하도록 AuthenticationManager에게 위임
         * 사용자가 입력한 email, password가 UserDetails를 통해 읽어온 UserDetails 객체에 들어있는 emial, password와 일치하는지 확인
         * 인증이 성공적으로 완료되면 SecurityContextHolder에 저장된다.
         */
        return authenticationManager.authenticate(authentication);
    }


}
