package com.sopt.seminar.common;

import com.sopt.seminar.common.dto.ErrorCode;
import com.sopt.seminar.common.dto.ErrorResponse;
import com.sopt.seminar.exception.CustomException;
import com.sopt.seminar.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ErrorResponse.of(
                        e.getErrorCode().getHttpStatus(),
                        e.getMessage()
                ));
    }

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException e) {
        return ResponseEntity
                .status(e.getErrorCode().getHttpStatus())
                .body(ErrorResponse.of(
                        e.getErrorCode().getHttpStatus(),
                        e.getMessage()
                ));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

        ErrorCode errorCode = ErrorCode.INVALID_VALUE;
        return ResponseEntity.status(errorCode.getHttpStatus())
                .body(ErrorResponse.of(
                        errorCode.getHttpStatus(),
                        errorCode.getMessage(),
                        e.getBindingResult()
                ));
    }
}