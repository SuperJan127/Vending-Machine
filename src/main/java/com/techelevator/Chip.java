package com.techelevator;

import java.math.BigDecimal;

public class Chip extends Item{
    public Chip(String name, BigDecimal price, String location){
        super(name, price, location);
        super.setDispenseMessage("Crunch Crunch, Yum!");
    }
}
