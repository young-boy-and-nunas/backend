package com.youngboyandnunas.backend.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    /* 400 BAD_REQUEST : 잘못된 요청 */
    BAD_REQUEST_ERROR(BAD_REQUEST, "Bad Request"),

    /* 401 UNAUTHORIZED : 인증되지 않은 사용자 */
    UNAUTHORIZED_ERROR(UNAUTHORIZED, "Unauthorized"),

    /* 404 NOT_FOUND : Resource 를 찾을 수 없음 */
    NOT_FOUND_ERROR(NOT_FOUND, "Not Found"),
    ALL_ALREADY_EXISTS(CONFLICT, "All Already Exists")

    ;

    private final HttpStatus httpStatus;
    private final String detail;
}
