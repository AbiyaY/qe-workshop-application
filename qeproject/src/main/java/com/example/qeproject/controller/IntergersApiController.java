package com.example.qeproject.controller;

import com.example.qeproject.model.Integers;
import com.example.qeproject.service.IntegersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
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
    public void enterTwoNumbers(@RequestBody Integers integers){
        integersService.storeIntegers(integers);
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/mathservice/integers";
//        HttpEntity<Integers> request = new HttpEntity<Integers>(integersService.getIntegers());
//        restTemplate.exchange(
//                resourceUrl,
//                HttpMethod.PUT,
//                request,
//                Void.class);
        Void integerCreateResponse = restTemplate
                .postForObject(resourceUrl, integersService.getIntegers(), Void.class);
        //return integerCreateResponse;
    }
}
