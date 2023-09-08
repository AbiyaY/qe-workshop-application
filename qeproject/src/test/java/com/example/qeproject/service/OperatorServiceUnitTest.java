package com.example.qeproject.service;

import com.example.qeproject.model.OperatorEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@ExtendWith(MockitoExtension.class)
public class OperatorServiceUnitTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private OperatorService operatorService = new OperatorService();


    @Test
    public void storeOperatorAndMakePostRequest () throws Exception {

        final OperatorEnum operatorEnum = OperatorEnum.MULTIPLY;
        operatorService.storeOperator(operatorEnum);

        String resourceUrl = "http://localhost:8080/mathservice/operator";
        ResponseEntity<Double> result = new ResponseEntity<Double>(HttpStatus.CREATED);

        Mockito.when(restTemplate.postForEntity(resourceUrl, operatorEnum, Double.class))
                .thenReturn(new ResponseEntity<Double>(5.0, HttpStatus.CREATED));




       Assertions.assertEquals(HttpStatus.CREATED, operatorService.makePostRequestToMathService().getStatusCode());
       Assertions.assertEquals(5.0, operatorService.makePostRequestToMathService().getBody());

    }

}
