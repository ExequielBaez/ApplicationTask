package com.exe.applicationTask.exception.handler;

import com.exe.applicationTask.exception.RegisterNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.management.RuntimeErrorException;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RegisterNotFound.class)
    protected ResponseEntity<Object>  handleRegisterNotFound(RuntimeException ex, WebRequest request){

        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timeStamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        body.put("Error", HttpStatus.NOT_FOUND.toString());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);

    }
}
