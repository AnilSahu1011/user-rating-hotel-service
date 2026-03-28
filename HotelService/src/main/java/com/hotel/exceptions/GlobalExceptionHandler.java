package com.hotel.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleException(Exception e){
        Map map = new HashMap<>();
        map.put("message", e.getMessage());
        map.put("status", false);
        map.put("timestamp", Instant.now().toString());

        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}
