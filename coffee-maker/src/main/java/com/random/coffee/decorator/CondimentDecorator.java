package com.random.coffee.decorator;

import com.random.coffee.Beverage;

public abstract class CondimentDecorator extends Beverage {
    public Beverage beverage;
    public CondimentDecorator(Beverage beverage){
        this.beverage=beverage;
    }

    public abstract String description() ;

}
