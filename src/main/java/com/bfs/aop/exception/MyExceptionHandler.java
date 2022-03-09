package com.bfs.aop.exception;

import com.bfs.aop.domain.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
    public static class AgeIllegalArgumentException extends Exception{
        public AgeIllegalArgumentException(String s) {
            super(s);
        }
    }
    @ExceptionHandler(value={AgeIllegalArgumentException.class})
    public ResponseEntity<ErrorMessage> handlerAgeIllegalArgument(AgeIllegalArgumentException e){
        return new ResponseEntity(ErrorMessage.builder().msg(e.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }
}
