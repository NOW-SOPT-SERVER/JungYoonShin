package com.sopt.carrotMarket.domain.user.controller;


import com.sopt.carrotMarket.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {
    private UserService userService;
//    @PostMapping("/api/auth/signup")
//    public String getUserInfo(@) {
//
//    }

}
