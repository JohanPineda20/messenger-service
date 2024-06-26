package com.pragma.messengerservice.infraestructure.exceptionhandler;

import com.twilio.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor {
    private final String MESSAGE = "message";
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleMethodArgumentNotValid(MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, String> body = new HashMap<>();
        methodArgumentNotValidException.getAllErrors().forEach(e -> {
            String fieldName = ((FieldError) e).getField();
            String message = e.getDefaultMessage();
            body.put(fieldName, message);
        });
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Map<String, String>> handleTwilioApiException(ApiException apiException){
        return new ResponseEntity<>(Collections.singletonMap(MESSAGE, apiException.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}