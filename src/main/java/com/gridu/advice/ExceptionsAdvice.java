package com.gridu.advice;

import com.gridu.exception.ResourceNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionsAdvice {
    private class JsonResponse {
        String error;

        public JsonResponse() {
        }

        public JsonResponse(String error) {
            super();
            this.error = error;
        }

        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }
    }

    @ResponseBody
    @ExceptionHandler(ResourceNotFoundException.class)
    public JsonResponse resourceNotFoundHandler(RuntimeException ex) {
        return new JsonResponse(ex.getMessage());
    }

}
