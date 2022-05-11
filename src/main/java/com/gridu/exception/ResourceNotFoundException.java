package com.gridu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -7806029002430564887L;
    private String resourceName;
    private Object resourceValue;

    public ResourceNotFoundException(String resourceName, Object resourceValue) {
        super(String.format("%s %s is not found", resourceName, resourceValue));
        this.resourceName = resourceName;
        this.resourceValue = resourceValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public Object getResourceValue() {
        return resourceValue;
    }

}
