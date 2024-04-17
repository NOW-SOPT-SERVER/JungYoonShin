package com.sopt.carrotMarket.domain.item.controller;

import com.sopt.carrotMarket.domain.item.service.ItemService;
import com.sopt.carrotMarket.domain.item.service.dto.ItemPostRequest;
import com.sopt.carrotMarket.global.ApiUtils;
import com.sopt.carrotMarket.global.CommonResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/item/post")
@Slf4j

public class ItemController {
    private final ItemService itemService;

    @PostMapping
    public CommonResponse createPost(@Validated @RequestBody ItemPostRequest itemPostRequest) {
        itemService.createPost(itemPostRequest);
        return ApiUtils.success(200, HttpStatus.OK, itemPostRequest);
    }
}
