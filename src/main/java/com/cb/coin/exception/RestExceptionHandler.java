package com.cb.coin.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        return new ResponseEntity<>(new ApiError(ErrorCode.INTERNAL_ERROR.getCode(), "internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(ApplicationException.class)
    protected ResponseEntity<Object> handleApplicationException(ApplicationException ex) {
        return new ResponseEntity<>(new ApiError(ErrorCode.INTERNAL_ERROR.getCode(), "internal server error"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(TokenNotFoundException.class)
    protected ResponseEntity<Object> handleTokenNotFound(TokenNotFoundException ex) {
        return new ResponseEntity<>(new ApiError(ErrorCode.NOT_FOUND.getCode(), ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CoinAlreadyExistException.class)
    protected ResponseEntity<Object> handleCoinAlreadyExist(CoinAlreadyExistException ex) {
        return new ResponseEntity<>(new ApiError(ErrorCode.CONFLICT.getCode(), "Coin already exist."), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(CoindeskIntegrationException.class)
    protected ResponseEntity<Object> handleIntegrationException(CoindeskIntegrationException ex) {
        return new ResponseEntity<>(new ApiError(ErrorCode.INTERNAL_ERROR.getCode(), ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
