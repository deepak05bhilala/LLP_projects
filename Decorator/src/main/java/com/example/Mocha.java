package com.example;

public class Mocha extends CondimentDecorator{

    Beverage beverage;

    public Mocha(Beverage beverage){
        this.beverage=beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+"Mocha";
    }

    @Override
    public Integer cost() {
        return beverage.cost()+3;
    }
}
