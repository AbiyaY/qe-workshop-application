package com.example.qeproject.controller;

import com.example.qeproject.model.Integers;
import com.example.qeproject.service.IntegersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/numberservice")
public class IntergersApiController {

    @Autowired
    private final IntegersService integersService;

    public IntergersApiController(IntegersService integersService){
        this.integersService = integersService;
    }

    @GetMapping
    public Integers getIntegers() {
        return integersService.getIntegers();
    }
    @PostMapping
    public Integer enterTwoNumbers(@RequestBody Integers integers){
        integersService.storeIntegers(integers);
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/mathservice/integers";
        HttpEntity<Integers> request = new HttpEntity<Integers>(integersService.getIntegers());
        Integer integerCreateResponse = restTemplate
                .postForObject(resourceUrl, request, Integer.class);
        return integerCreateResponse;
    }
}
