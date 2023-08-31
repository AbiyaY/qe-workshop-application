package com.example.qeproject.controller;

import com.example.qeproject.model.IntegerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/numberservice")
public class IntergerApiController {

    IntegerService integerService;

    @GetMapping("/integers")
    public IntegerService getIntegers() {
        return integerService;
    }
    @PostMapping
    public String enterTwoNumbers(@RequestBody IntegerService integerService){
        this.integerService = integerService;
        return "Numbers entered successfully";
    }
}
