package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Item{
    public Gum(String name, BigDecimal price, String location){
        super(name, price, location);
        super.setDispenseMessage("Chew Chew, Yum!");
    }
}
