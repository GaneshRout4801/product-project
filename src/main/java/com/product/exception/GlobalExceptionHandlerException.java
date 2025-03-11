package com.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandlerException {

    @ExceptionHandler(CategoryAlreadyExistException.class)
    public ResponseEntity<ExceptionResponse> handleCategoryAlreadyExistException(CategoryAlreadyExistException ex, WebRequest webRequest){
        ExceptionResponse exceptionResponse=new ExceptionResponse();
        exceptionResponse.setApiPath(webRequest.getDescription(false));
        exceptionResponse.setErrorMessage(ex.getMessage());
        exceptionResponse.setStatusCode(HttpStatus.CONFLICT);
        exceptionResponse.setErrorTime(LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.CONFLICT);

    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleCategoryNotFoundException(CategoryNotFoundException ex, WebRequest webRequest){
        ExceptionResponse exceptionResponse=new ExceptionResponse();
        exceptionResponse.setApiPath(webRequest.getDescription(false));
        exceptionResponse.setErrorMessage(ex.getMessage());
        exceptionResponse.setStatusCode(HttpStatus.NOT_FOUND);
        exceptionResponse.setErrorTime(LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);

    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleProductNotFoundException(ProductNotFoundException ex, WebRequest webRequest){
        ExceptionResponse exceptionResponse=new ExceptionResponse();
        exceptionResponse.setApiPath(webRequest.getDescription(false));
        exceptionResponse.setErrorMessage(ex.getMessage());
        exceptionResponse.setStatusCode(HttpStatus.NOT_FOUND);
        exceptionResponse.setErrorTime(LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionResponse> handleGlobalException(Exception ex, WebRequest webRequest){
        ExceptionResponse exceptionResponse=new ExceptionResponse();
        exceptionResponse.setApiPath(webRequest.getDescription(false));
        exceptionResponse.setErrorMessage(ex.getMessage());
        exceptionResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        exceptionResponse.setErrorTime(LocalDateTime.now());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
