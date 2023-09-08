package com.example.qeproject.service;

import com.example.qeproject.model.Integers;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.system.OutputCaptureRule;
import org.springframework.http.*;
import org.springframework.test.web.client.ExpectedCount;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class IntegersServiceTest {
    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private IntegersService intService = new IntegersService();


    @Test
    public void makePostRequestToMathServiceTest_isCreated(){
        List<Integers> storedIntegers = new ArrayList<Integers>();
        Integers intValues = new Integers(2,2);
        storedIntegers.add(intValues);

        ResponseEntity<Void> result = new ResponseEntity<Void>(HttpStatus.CREATED);

        Mockito.when(restTemplate.postForEntity("http://localhost:8080/mathservice/integers", storedIntegers.get(0), Void.class))
                .thenReturn(result);

        Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }
}