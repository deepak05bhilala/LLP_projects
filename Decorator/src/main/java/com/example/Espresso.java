package com.example;

public class Espresso extends Beverage{

    public Espresso(){
        description="Espresso";
    }

    @Override
    public Integer cost() {
        return 10;
    }
}
