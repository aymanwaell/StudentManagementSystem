package com.AnywareSoftware.StudentManagementSystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleError404(HttpServletRequest request, Exception e) {
        return "404"; //
    }

    @ExceptionHandler({ HttpClientErrorException.class, Throwable.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleError4xx(HttpServletRequest request, Exception e) {
        return "errors4";
    }

    @ExceptionHandler(HttpServerErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleError5xx(HttpServletRequest request, Exception e) {
        return "errors5";
    }
}
