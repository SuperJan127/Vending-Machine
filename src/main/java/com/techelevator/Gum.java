package com.techelevator;

public class Gum extends Item{
    public Gum(String name, double price, String location){
        super(name, price, location);
        super.setDispenseMessage("Chew Chew, Yum!");
    }
}
