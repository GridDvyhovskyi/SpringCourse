package com.gridu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class InvalidArgumentException extends RuntimeException {

    private static final long serialVersionUID = -7806029002430564887L;

    public InvalidArgumentException() {
        super("Parameters have invalid format or absent");
    }

}
