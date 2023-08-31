package com.example.qeproject.controller;

import com.example.qeproject.model.OperatorService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/operatorservice")
public class OperatorApiController {

    OperatorService operatorService;
    @GetMapping("/operator")
    public OperatorService getOperator(){
        return operatorService;
    }

    @PostMapping
    public String enterOperator(@RequestBody OperatorService operatorService){
        this.operatorService = operatorService;
        return "Operator entered successfully";
    }

}
