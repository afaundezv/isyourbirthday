package com.latam.isyourbirthday.controller;

import com.latam.isyourbirthday.model.ApiError;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.DateTimeException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class IsYourBirthdayControllerAdviceTest {

    @Test
    public void testShouldThrowsDateTimeException() throws DateTimeException {
        IsYourBirthdayControllerAdvice advice = new IsYourBirthdayControllerAdvice();

        ResponseEntity<ApiError> response = advice.dateTimeException(new DateTimeException("error forzado"));

        Assert.assertEquals("Error con la fecha ingresada", response.getBody().getMessage());
    }

    @Test
    public void testShouldThrowsArrayIndexOutOfBoundsException() throws ArrayIndexOutOfBoundsException {
        IsYourBirthdayControllerAdvice advice = new IsYourBirthdayControllerAdvice();

        ResponseEntity<ApiError> response = advice.arrayIndexOutOfBoundsException(new ArrayIndexOutOfBoundsException("error forzado"));

        Assert.assertEquals("El formato de Fecha debe ser dd-MM-yyyy", response.getBody().getMessage());
    }
}
