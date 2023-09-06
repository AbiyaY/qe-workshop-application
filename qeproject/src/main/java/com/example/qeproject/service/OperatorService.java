package com.example.qeproject.service;

import com.example.qeproject.model.Integers;
import com.example.qeproject.model.Operator;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OperatorService {
    private List<Operator> storedOperator = new ArrayList<Operator>();

    public void storeOperator(Operator operator){
        storedOperator.clear();
        storedOperator.add(operator);
    }

    public Double makePostRequestToMathService() {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/mathservice/operator";
        Double response = restTemplate
                .postForObject(resourceUrl, storedOperator.get(0), Double.class);
        return response;
    }

}
