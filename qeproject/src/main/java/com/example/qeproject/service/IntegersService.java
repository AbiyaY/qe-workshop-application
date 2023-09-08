package com.example.qeproject.service;

import com.example.qeproject.model.Integers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class IntegersService {

    private List<Integers> storedIntegers = new ArrayList<Integers>();
    @Autowired
    RestTemplate restTemplate;
    public void storeIntegers(Integers integers){
        storedIntegers.clear();
        storedIntegers.add(integers);
    }

    public void makePostRequestToMathService() {
        String resourceUrl = "http://localhost:8080/mathservice/integers";

        ResponseEntity<Void> integerCreateResponse = restTemplate
                .postForEntity(resourceUrl, storedIntegers.get(0), Void.class);
    }
}
