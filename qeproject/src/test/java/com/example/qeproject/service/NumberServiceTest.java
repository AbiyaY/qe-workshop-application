package com.example.qeproject.service;

import com.example.qeproject.model.NumberRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;



@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class NumberServiceTest {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private NumberService numberService = new NumberService();


    @Test
    public void makePostRequestToMathServiceTest_isCreated(){

        NumberRepo numberRepo = new NumberRepo(2,2);
        numberService.storeIntegers(numberRepo);

        Mockito.when(restTemplate.postForEntity("http://localhost:8080/mathservice/integers", numberRepo, Void.class))
                .thenReturn(new ResponseEntity<Void>(HttpStatus.CREATED));

        Assertions.assertEquals(HttpStatus.CREATED, numberService.makePostRequestToMathService().getStatusCode());
    }
}