package com.techelevator;

import java.math.BigDecimal;

public class Drink extends Item{
    public Drink(String name, BigDecimal price, String location){
        super(name, price, location);
        super.setDispenseMessage("Glug Glug, Yum!");
    }
}
