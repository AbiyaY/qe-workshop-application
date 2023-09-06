package com.example.qeproject.service;

import com.example.qeproject.model.Integers;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class IntegersService {
    private List<Integers> storedIntegers = new ArrayList<Integers>();
    public void storeIntegers(Integers integers){
        storedIntegers.clear();
        storedIntegers.add(integers);
    }

    public void makePostRequestToMathService() {
        String resourceUrl = "http://localhost:8080/mathservice/integers";

        RestTemplate restTemplate = new RestTemplate();
        Void integerCreateResponse = restTemplate
                .postForObject(resourceUrl, storedIntegers.get(0), Void.class);
    }
}
