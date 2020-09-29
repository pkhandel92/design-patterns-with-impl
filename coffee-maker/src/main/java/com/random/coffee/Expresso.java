package com.random.coffee;

public class Expresso extends Beverage{

    @Override
    public String description() {
        return "Expresso";
    }

    @Override
    public double cost() {
        return 0.28;
    }
}
