package org.example.productcatalogservice_jan2025.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerAdvisor {
    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<String> handleProductNotFoundException(RuntimeException e) {
        return new ResponseEntity<>("Product Id is not valid", HttpStatus.BAD_REQUEST);
    }
}
