package com.example.qeproject.model;

public class OperatorService {
    private String operator;

    public OperatorService(){}

    public OperatorService(String operator){
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
