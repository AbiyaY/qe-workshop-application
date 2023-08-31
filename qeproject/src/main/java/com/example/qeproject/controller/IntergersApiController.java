package com.example.qeproject.controller;

import com.example.qeproject.model.Integers;
import com.example.qeproject.service.IntegersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public String enterTwoNumbers(@RequestBody Integers integers){
        integersService.storeIntegers(integers);
        return "Numbers entered successfully";
    }
}
