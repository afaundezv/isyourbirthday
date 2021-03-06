package com.latam.isyourbirthday.controller;

import com.latam.isyourbirthday.model.ApiError;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.DateTimeException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice(annotations = RestController.class)
public class IsYourBirthdayControllerAdvice  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DateTimeException.class)
    protected ResponseEntity<ApiError> dateTimeException(DateTimeException ex) {
        return new ResponseEntity<>(new ApiError(BAD_REQUEST.value(), "Error con la fecha ingresada",ex.getMessage()),BAD_REQUEST);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    protected ResponseEntity<ApiError> arrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException ex) {
        return new ResponseEntity<>(new ApiError(BAD_REQUEST.value(), "El formato de Fecha debe ser dd-MM-yyyy",ex.getLocalizedMessage()),BAD_REQUEST);
    }
}
