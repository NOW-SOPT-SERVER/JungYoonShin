package com.sopt.carrotMarket.global.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    //custom exception
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        return ResponseEntity
            .status(e.getErrorCode().getHttpStatus())
            .body(new ErrorResponse(e));
    }

    //@Valid exception
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException e) {
        //DTO 설정 메시지
        String message = e.getBindingResult().getFieldError().getDefaultMessage();

        CustomException validException = new CustomException(ErrorCode.INVALID_VALUE, message);
        return ResponseEntity
            .status(validException.getErrorCode().getHttpStatus())
            .body(new ErrorResponse(validException));
    }
}
