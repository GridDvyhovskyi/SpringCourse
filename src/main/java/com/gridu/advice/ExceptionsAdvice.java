package com.gridu.advice;

import com.gridu.exception.InvalidArgumentException;
import com.gridu.exception.ResourceNotFoundException;
import lombok.*;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionsAdvice {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    private class JsonResponse {
        String error;
    }


    @ResponseBody
    @ExceptionHandler(value = {ResourceNotFoundException.class, InvalidArgumentException.class})
    public JsonResponse errorHandler(RuntimeException ex) {
        return new JsonResponse(ex.getMessage());
    }

}
