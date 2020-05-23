package com.latam.isyourbirthday.controller;

import com.latam.isyourbirthday.business.IsYourBirthdayBusiness;
import com.latam.isyourbirthday.model.ResponseData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class IsYourBirthdayControllerTest {

    @Mock
    private ResponseData responseData;
    @MockBean
    private IsYourBirthdayBusiness isYourBirthdayBusiness;
    @Autowired
    private IsYourBirthdayController isYourBirthdayController;


    @Test
    public void testShouldStatus200() throws Exception {
        isYourBirthdayController = new IsYourBirthdayController(isYourBirthdayBusiness);
        String birthday = "21/05/2020";
        when(isYourBirthdayBusiness.execute("", "", "", birthday))
                .thenReturn(responseData);

        HttpStatus statusCode = isYourBirthdayController
                .isYourBirthday("", "", "", birthday)
                .getStatusCode();

        Assert.assertEquals(statusCode, HttpStatus.OK);
    }
}
