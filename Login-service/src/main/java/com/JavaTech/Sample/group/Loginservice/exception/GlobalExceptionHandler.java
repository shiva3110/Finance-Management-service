package com.JavaTech.Sample.group.Loginservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{



    @ExceptionHandler(UserNotFound.class)
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFound ex, WebRequest request)
    {
        return new ResponseEntity(ex, HttpStatus.OK);
    }
    @ExceptionHandler(NullPointerException.class)
    public final ResponseEntity<Object> handleNullpointerException(UserNotFound ex, WebRequest request)
    {
        return new ResponseEntity(ex, HttpStatus.OK);
    }
}
