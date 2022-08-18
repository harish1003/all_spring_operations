package com.oracle.databaseOracle.entity;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ErrorMessage {
    private String message;
    private HttpStatus httpStatus;
}
