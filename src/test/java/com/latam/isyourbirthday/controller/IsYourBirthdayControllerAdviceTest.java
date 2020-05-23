package com.latam.isyourbirthday.controller;

import com.latam.isyourbirthday.model.ApiError;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class IsYourBirthdayControllerAdviceTest {

    @Test
    public void testShouldThrowCustomerError() throws ParseException {
        IsYourBirthdayControllerAdvice advice = new IsYourBirthdayControllerAdvice();

        ResponseEntity<ApiError> response = advice.parseExceptionDate(new ParseException("error forzado", 1));

        Assert.assertEquals("El formato de Fecha debe ser dd-MM-yyyy", response.getBody().getMessage());

    }
}
