package com.example.qeproject.controller;

import com.example.qeproject.model.Integers;
import com.example.qeproject.model.Operator;
import com.example.qeproject.model.OperatorEnum;
import com.example.qeproject.service.IntegersService;
import com.example.qeproject.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
@RequestMapping("/operatorservice")
public class OperatorApiController {

    @Autowired
    private final OperatorService operatorService;

    public OperatorApiController(OperatorService operatorService){
        this.operatorService = operatorService;
    }

    @PostMapping
    public ResponseEntity<Double> enterOperator(@RequestBody OperatorEnum operatorEnum){
        operatorService.storeOperator(operatorEnum);
        return operatorService.makePostRequestToMathService();
    }

}
