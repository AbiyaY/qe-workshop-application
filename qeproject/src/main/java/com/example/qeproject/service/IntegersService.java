package com.example.qeproject.service;

import com.example.qeproject.model.Integers;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class IntegersService {
    private ArrayList<Integers> storedIntegers = new ArrayList<Integers>();
    public void storeIntegers(Integers integers){
        storedIntegers.clear();
        storedIntegers.add(integers);
    }

    public Integers getIntegers(){
        return storedIntegers.get(0);
    }
}
