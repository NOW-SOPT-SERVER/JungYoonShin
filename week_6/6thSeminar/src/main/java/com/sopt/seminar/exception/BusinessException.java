package com.sopt.seminar.exception;

import com.sopt.seminar.common.dto.ErrorMessage;

import java.util.logging.ErrorManager;

public class BusinessException extends RuntimeException {
    private ErrorMessage errorMessage;

    public BusinessException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorMessage = errorMessage;
    }
}
