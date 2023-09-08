package com.example.qeproject.controller;

import com.example.qeproject.model.OperatorEnum;
import com.example.qeproject.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/operatorservice")
public class OperatorController {

    @Autowired
    private final OperatorService operatorService;

    public OperatorController(OperatorService operatorService){
        this.operatorService = operatorService;
    }

    @PostMapping
    public ResponseEntity<Double> enterOperator(@RequestBody OperatorEnum operatorEnum){
        operatorService.storeOperator(operatorEnum);
        return new ResponseEntity<Double>(operatorService.makePostRequestToMathService(), HttpStatus.CREATED);
    }

}
