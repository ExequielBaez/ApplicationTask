package com.exe.applicationTask.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseBody
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RegisterNotFound extends RuntimeException{

    public RegisterNotFound(String message){
        super(message);
    }

    public String getMessage(){
        return super.getMessage();
    }
}

