package com.techelevator;

public class Chip extends Item{
    public Chip(String name, double price, String location){
        super(name, price, location);
        super.setDispenseMessage("Crunch Crunch, Yum!");
    }
}
