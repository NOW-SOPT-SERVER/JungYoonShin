package com.sopt.seminar.service.dto;

import org.springframework.web.multipart.MultipartFile;

public record BlogCreateRequset(
        String title,
        String description,
        MultipartFile image
) {
}
