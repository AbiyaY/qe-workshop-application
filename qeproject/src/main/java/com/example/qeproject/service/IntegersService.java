package com.example.qeproject.service;

import com.example.qeproject.model.Integers;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
@Service
public class IntegersService {
    private ArrayList<Integers> storedIntegers = new ArrayList<Integers>();
    public void storeIntegers(Integers integers){
        storedIntegers.clear();
        storedIntegers.add(integers);
    }

    public void makePostRequestToMathService() {
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/mathservice/integers";
        Void integerCreateResponse = restTemplate
                .postForObject(resourceUrl, getIntegers(), Void.class);
    }

    public Integers getIntegers(){
        return storedIntegers.get(0);
    }
}
