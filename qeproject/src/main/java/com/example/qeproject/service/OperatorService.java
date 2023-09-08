package com.example.qeproject.service;

import com.example.qeproject.model.OperatorEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OperatorService {

    private OperatorEnum operatorEnum;

    @Autowired
    RestTemplate restTemplate;


    public void storeOperator(OperatorEnum operatorEnum){
        this.operatorEnum = operatorEnum;
    }

    public ResponseEntity<Double> makePostRequestToMathService() {
        String resourceUrl = "http://localhost:8080/mathservice/operator";
        ResponseEntity<Double> response = restTemplate.postForEntity(resourceUrl, operatorEnum, Double.class);
        return response;
    }

}
