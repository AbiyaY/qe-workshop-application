package com.example.qeproject.model;

public class NumberRepo {

    private final Number number1;

    private final Number number2;

    public NumberRepo(Number number1, Number number2){
        this.number1 = number1;
        this.number2 = number2;
    }

    public Number getNumber1() {
        return number1;
    }

    public Number getNumber2() {
        return number2;
    }


}
