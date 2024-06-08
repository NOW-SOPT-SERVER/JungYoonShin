package com.sopt.seminar.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.List;

@Builder
public record ErrorResponse(

        int httpStatus,
        String message,

        @JsonInclude(JsonInclude.Include.NON_NULL)
        List<ValidationError> errors
) {
    public static ErrorResponse of(int httpStatus, String message){
        return ErrorResponse.builder()
                .httpStatus(httpStatus)
                .message(message)
                .build();
    }
    public static ErrorResponse of(int httpStatus, String message, BindingResult bindingResult){
        return ErrorResponse.builder()
                .httpStatus(httpStatus)
                .message(message)
                .errors(ValidationError.of(bindingResult))
                .build();
    }

    @Getter
    public static class ValidationError {
        private final String field;
        private final String message;

        private ValidationError(FieldError fieldError){
            this.field = fieldError.getField();
            this.message = fieldError.getDefaultMessage();
        }

        public static List<ValidationError> of(final BindingResult bindingResult){
            return bindingResult.getFieldErrors().stream()
                    .map(ValidationError::new)
                    .toList();
        }
    }
}
