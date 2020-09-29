package com.random.coffee.condiments;

import com.random.coffee.Beverage;
import com.random.coffee.decorator.CondimentDecorator;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String description() {
        return beverage.description()+" ,SOY";
    }

    @Override
    public double cost() {
        return beverage.cost()+0.89;
    }
}
