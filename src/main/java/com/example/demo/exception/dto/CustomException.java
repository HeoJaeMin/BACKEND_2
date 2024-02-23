package com.example.demo.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Builder
@Getter
public class CustomException extends RuntimeException {
    private HttpStatus status;
    private String message;
}