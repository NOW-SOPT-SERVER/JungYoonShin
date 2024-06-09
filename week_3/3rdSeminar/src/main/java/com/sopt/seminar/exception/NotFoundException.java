package com.sopt.seminar.exception;

import com.sopt.seminar.common.dto.ErrorCode;

public class NotFoundException extends BusinessException {

    public NotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
}
