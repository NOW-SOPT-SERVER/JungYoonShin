package com.sopt.carrotMarket.domain.item.service.dto;

public record ItemPostRequest(
        String title,
        String description,
        int price
) {
}
