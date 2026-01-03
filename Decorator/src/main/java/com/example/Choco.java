package com.example;

public class Choco extends CondimentDecorator{

    Beverage beverage;

    public Choco(Beverage beverage){
        this.beverage=beverage;
    }
    @Override
    public String getDescription() {
        return beverage.getDescription()+"Choco";
    }

    @Override
    public Integer cost() {
        return beverage.cost()+6;
    }
}
