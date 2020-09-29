package com.random.coffee;

import com.random.coffee.condiments.Soy;
import com.random.coffee.condiments.Whip;

public class ApplicationDriver {
    public static void main(String[] args) {
        Beverage beverage=new Expresso();
        beverage=new Whip(beverage);
        beverage=new Soy(beverage);
        System.out.println(beverage.description());
        System.out.println(beverage.cost());

    }
}
