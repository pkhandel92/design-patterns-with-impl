package com.random.coffee.condiments;

import com.random.coffee.Beverage;
import com.random.coffee.decorator.CondimentDecorator;

public class Whip extends CondimentDecorator {

    public Whip(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String description() {
        return beverage.description()+",Whip";
    }

    @Override
    public double cost() {
        return beverage.cost()+0.19;
    }
}
