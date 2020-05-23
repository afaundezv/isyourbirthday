package com.latam.isyourbirthday.service;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WrapperRestTemplate {

    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}
