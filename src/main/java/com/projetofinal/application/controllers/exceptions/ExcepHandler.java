package com.projetofinal.application.controllers.exceptions;

import com.projetofinal.domain.services.excpetions.ArgumentoInvalidoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExcepHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> handlerMethodArgumentNotValidException(MethodArgumentNotValidException m, HttpServletRequest request) {
        StandardError error = new StandardError();
        error.setPath(request.getRequestURI());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(System.currentTimeMillis());
        error.setMessage(m.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(ArgumentoInvalidoException.class)
    public ResponseEntity<StandardError> handlerArgumentoInvalidoException(ArgumentoInvalidoException m, HttpServletRequest request) {
        StandardError error = new StandardError();
        error.setPath(request.getRequestURI());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimestamp(System.currentTimeMillis());
        error.setMessage(m.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
