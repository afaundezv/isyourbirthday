package com.latam.isyourbirthday.service;

import com.latam.isyourbirthday.model.Poem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class CallRandomPoem {

    @Value("${randomPoem.protocol}")
    private String protocol;

    @Value("${randomPoem.host}")
    private String host;

    @Value("${randomPoem.uri}")
    private String uri;

    private WrapperRestTemplate wrapperRestTemplate;

    @Autowired
    CallRandomPoem(WrapperRestTemplate restTemplate){
        wrapperRestTemplate = restTemplate;
    }



    public Poem getPoem() {
        ResponseEntity<Poem[]> response =
               wrapperRestTemplate.getRestTemplate().getForEntity(
                        getUrl(),
                        Poem[].class);
        Poem[] poems = response.getBody();
        return poems[0];
    }

    private String getUrl() {
        return new StringBuilder().append(protocol).append(host).append(uri).toString();
    }


}
