package com.youngboyandnunas.backend.global.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity<ErrorResponse> handleException(GlobalException exception) {
        ErrorCode code = exception.getErrorCode();
        return new ResponseEntity<>(ErrorResponse.builder()
                .status(code.getHttpStatus().value())
                .error(code.getHttpStatus().name())
                .code(code.name())
                .message(code.getDetail())
                .build(), code.getHttpStatus());
    }

}
