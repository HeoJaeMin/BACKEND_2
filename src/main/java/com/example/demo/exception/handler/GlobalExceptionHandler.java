package com.example.demo.exception.handler;

import com.example.demo.exception.dto.CustomException;
import com.example.demo.exception.dto.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorDetail> handleCustomException(CustomException e) {
        return new ResponseEntity<>(ErrorDetail.builder()
                .message(e.getMessage())
                .build(), e.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetail> handleException(Exception e) {
        return new ResponseEntity<>(ErrorDetail.builder().message("오류가 발생했습니다.").build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
