package com.sopt.practice.controller;

import com.sopt.practice.dto.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TextController {

    @GetMapping()
    public String test() {
        return "test API";
    }

    @GetMapping("/json")
    public ApiResponse testJson() {
        return ApiResponse.create("1차 세미나 테스트 API - JSON");
    }
}
