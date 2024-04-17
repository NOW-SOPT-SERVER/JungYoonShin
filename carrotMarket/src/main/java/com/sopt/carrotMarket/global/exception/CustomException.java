package com.sopt.carrotMarket.global.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private ErrorCode errorCode;
    private String errorMessage;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getDetail());
        this.errorCode = errorCode;
        this.errorMessage = errorCode.getDetail();
    }

    //@Valid 오류처리
    public CustomException(ErrorCode errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

}
