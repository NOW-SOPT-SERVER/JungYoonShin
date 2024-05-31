package com.sopt.seminar.jwt;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class UserAuthentication extends UsernamePasswordAuthenticationToken {

    public UserAuthentication(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities) {
        super(principal, credentials, authorities);
    }

    public static UserAuthentication createUserAuthentication(String email) {
        return new UserAuthentication(email, null, null);
    }

    public static UserAuthentication createUserAuthentication(String email, String password) {
        return new UserAuthentication(email, password, null);
    }
}