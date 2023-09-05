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
        integersService.makePostRequestToMathService();
    }
}
