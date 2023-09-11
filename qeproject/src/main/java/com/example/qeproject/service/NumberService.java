package com.example.qeproject.service;

import com.example.qeproject.model.NumberRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class NumberService {

    private NumberRepo numberRepo;
    @Autowired
    RestTemplate restTemplate;

    public void storeIntegers(NumberRepo numberRepo){
        this.numberRepo = numberRepo;
    }

    public ResponseEntity<Void> makePostRequestToMathService() {
        String resourceUrl = "http://localhost:8080/mathservice/integers";

        ResponseEntity<Void> response =
            restTemplate.postForEntity(resourceUrl, numberRepo, Void.class);

        return response;
    }
}
