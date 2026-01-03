package com.example;

import lombok.Getter;

@Getter
public abstract class Beverage {
    public String description="Unknown Beverage";

    public abstract Integer cost();
}
