package com.fps.mpits.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author HieuDT28 (Hiếu Boy) - 19/05/2020
 */

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class NotAcceptableException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public NotAcceptableException(String message) {
        super(message);
    }

    public NotAcceptableException(String message, Throwable cause) {
        super(message, cause);
    }
}
