package com.techelevator;

public class Candy extends Item {
    public Candy(String name, double price, String location){
        super(name, price, location);
        super.setDispenseMessage("Munch Munch, Yum!");
    }
}
