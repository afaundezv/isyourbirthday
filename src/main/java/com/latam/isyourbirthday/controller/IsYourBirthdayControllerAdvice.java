package com.latam.isyourbirthday.controller;

import com.latam.isyourbirthday.model.ApiError;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.text.ParseException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice(annotations = RestController.class)
public class IsYourBirthdayControllerAdvice  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ParseException.class)
    protected ResponseEntity<ApiError> parseExceptionDate(ParseException ex) {
        return new ResponseEntity<ApiError>(new ApiError(BAD_REQUEST.value(), "El formato de Fecha es dd-MM-yyyy",ex.getMessage()),BAD_REQUEST);
    }


}
