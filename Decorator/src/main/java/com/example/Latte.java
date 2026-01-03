package com.example;

public class Latte extends Beverage{

    public Latte(){
        description="Latte";
    }

    @Override
    public Integer cost() {
        return 2;
    }
}
