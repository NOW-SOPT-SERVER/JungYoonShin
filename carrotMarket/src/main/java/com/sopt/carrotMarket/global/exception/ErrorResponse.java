package com.sopt.carrotMarket.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class ErrorResponse {

    private final int errorCode;
    private final String errorMessage;

    public ErrorResponse(CustomException e) {
        this.errorCode = e.getErrorCode().getErrorCode();
        this.errorMessage = e.getErrorMessage();
    }

}
