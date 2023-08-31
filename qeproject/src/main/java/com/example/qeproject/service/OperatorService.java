package com.example.qeproject.service;

import com.example.qeproject.model.Integers;
import com.example.qeproject.model.Operator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class OperatorService {
    private ArrayList<Operator> storedOperator = new ArrayList<Operator>();

    public void storeOperator(Operator operator){
        storedOperator.clear();
        storedOperator.add(operator);
    }

    public Operator getOperator(){
        return storedOperator.get(0);
    }
}
