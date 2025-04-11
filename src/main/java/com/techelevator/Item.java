package com.techelevator;

import java.math.BigDecimal;

public abstract class Item {
    private String name;
    private BigDecimal price;
    private String dispenseMessage;
    private String location;
    private int quantity;

    public String getLocation() {
        return location;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getDispenseMessage() {
        return dispenseMessage;
    }

    public void setDispenseMessage(String dispenseMessage) {
        this.dispenseMessage = dispenseMessage;
    }

    public Item(String name, BigDecimal price, String location){
        this.name = name;
        this.price = price;
        quantity = 5;
        this.location = location;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
