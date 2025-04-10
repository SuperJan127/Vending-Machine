package com.techelevator;

public class Drink extends Item{
    public Drink(String name, double price, String location){
        super(name, price, location);
        super.setDispenseMessage("Glug Glug, Yum!");
    }
}
