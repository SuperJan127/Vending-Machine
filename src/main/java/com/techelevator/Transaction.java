package com.techelevator;

public class Transaction {
    private double balance = 0;

    public double getBalance() {
        return balance;
    }

    public double addMoney(double moneyAdded){
        balance += moneyAdded;
        return balance;
    }
    public double useMoney(double moneyUsed){
        balance -= moneyUsed;
        return balance;
    }
}
