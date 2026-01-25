package com.spring.first.api.spring_first_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// @ResponseStatus บอกว่าถ้าเกิด Error นี้ ให้ส่ง HTTP Status 404 กลับไปเป็นค่าเริ่มต้น
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}