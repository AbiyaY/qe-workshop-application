package com.example.qeproject.controller;

import com.example.qeproject.model.Operator;
import com.example.qeproject.service.IntegersService;
import com.example.qeproject.service.OperatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String enterOperator(@RequestBody Operator operator){
        operatorService.storeOperator(operator);
        return "Operator entered successfully";
    }

}
