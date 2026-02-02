package com.spring.first.api.spring_first_api.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class GlobalExceptionHandler {

// ดักจับกรณีส่งตัวแปรผิดประเภท (เช่น ส่ง String ในช่อง int)
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", "รูปแบบข้อมูลไม่ถูกต้อง: " + ex.getValue());
        body.put("error", "Bad Request");
        
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST); // ตอบกลับด้วย 400
    }

    // ดักจับ ResourceNotFoundException ที่คุณสร้างไว้
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("message", ex.getMessage());
        
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND); // ตอบกลับด้วย 404
    }
}