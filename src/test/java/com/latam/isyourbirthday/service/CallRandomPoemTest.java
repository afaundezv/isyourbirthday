package com.latam.isyourbirthday.service;

import com.latam.isyourbirthday.model.Poem;
import com.latam.isyourbirthday.model.Poet;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@TestPropertySource(properties = {"spring.config.location = classpath:application.yaml"})
public class CallRandomPoemTest {

    @Autowired
    private CallRandomPoem callRandomPoem;
    @MockBean
    private WrapperRestTemplate wrapperRestTemplate;
    @Mock
    private ResponseEntity responseEntity;
    @Mock
    private RestTemplate restTemplate;

    private Poem mockPoem;

    @Before
    @SuppressWarnings("unchecked")
    public void setUp() throws Exception {
        mockPoem  = new Poem("hola","el gran poema", "nn", new Poet());
        Poem[] poems  = new Poem[]{mockPoem};
        callRandomPoem = new CallRandomPoem(wrapperRestTemplate);
        when(wrapperRestTemplate.getRestTemplate()).thenReturn(restTemplate);
        when(restTemplate.getForEntity("nullnullnull",Poem[].class)).thenReturn(responseEntity);
        when(responseEntity.getBody()).thenReturn(poems);
    }

    @Test
    public void testShouldGetPoem() {

        Poem poem = callRandomPoem.getPoem();

        Assert.assertEquals(mockPoem, poem);


    }
}
