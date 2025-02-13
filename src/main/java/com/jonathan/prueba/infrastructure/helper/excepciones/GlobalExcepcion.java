package com.jonathan.prueba.infrastructure.helper.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExcepcion extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Excepciones.class)
    public ResponseEntity<MensajeException> manejarGlobalException(Excepciones excepctiones, WebRequest webRequest) {
        MensajeException  mensajeException = MensajeException.builder().mensaje(excepctiones.getMessage()).build();
        return new ResponseEntity<>(mensajeException, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
