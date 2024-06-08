package com.sopt.carrotMarket.domain.item.controller;

import com.sopt.carrotMarket.domain.item.service.ItemService;
import com.sopt.carrotMarket.domain.item.service.dto.ItemPostRequest;
import com.sopt.carrotMarket.global.ApiUtils;
import com.sopt.carrotMarket.global.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/items")
@Slf4j

public class ItemController {
    private final ItemService itemService;

    @PostMapping
    public CommonResponse createPost(@Validated @RequestBody ItemPostRequest itemPostRequest, @RequestParam(value = "memberId", required = false) Long memberId) {
        itemService.createPost(itemPostRequest, memberId);
        return ApiUtils.success(200, HttpStatus.OK);
    }
}
