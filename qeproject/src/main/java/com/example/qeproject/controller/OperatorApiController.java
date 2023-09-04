package com.example.qeproject.controller;

import com.example.qeproject.model.Integers;
import com.example.qeproject.model.Operator;
import com.example.qeproject.service.IntegersService;
import com.example.qeproject.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/operatorservice")
public class OperatorApiController {

    @Autowired
    private final OperatorService operatorService;

    public OperatorApiController(OperatorService operatorService){
        this.operatorService = operatorService;
    }
    @GetMapping
    public Operator getOperator(){
        return operatorService.getOperator();
    }

    @PostMapping
    public Integer enterOperator(@RequestBody Operator operator){
        operatorService.storeOperator(operator);
        RestTemplate restTemplate = new RestTemplate();
        String resourceUrl = "http://localhost:8080/mathservice/operator";
        //HttpEntity<Operator> request = new HttpEntity<Operator>(operatorService.getOperator());
        Integer response = restTemplate
                .postForObject(resourceUrl, operatorService.getOperator(), Integer.class);
        return response;
//        operatorService.storeOperator(operator);
//        return "Operator entered successfully";
    }

}
