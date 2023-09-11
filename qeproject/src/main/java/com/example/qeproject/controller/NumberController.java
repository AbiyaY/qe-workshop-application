package com.example.qeproject.controller;

import com.example.qeproject.model.NumberRepo;
import com.example.qeproject.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/numberservice")
public class NumberController {

    @Autowired
    private final NumberService numberService;

    public NumberController(NumberService numberService){
        this.numberService = numberService;
    }

    @PostMapping
    public ResponseEntity<Void> enterTwoNumbers(@RequestBody NumberRepo integers){
        numberService.storeIntegers(integers);
        numberService.makePostRequestToMathService();

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
