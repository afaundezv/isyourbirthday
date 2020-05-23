package com.latam.isyourbirthday.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class WrapperRestTemplateTest {

    @Autowired
    WrapperRestTemplate wrapperRestTemplate;

    @Test
    public void testShouldReturnRestTemplate() {
        RestTemplate restTemplate = null;

        restTemplate = wrapperRestTemplate.getRestTemplate();

        Assert.assertNotNull(restTemplate);
    }
}
