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
        if(moneyUsed > balance){
            System.out.println("Insufficient funds, please add more money: ");
        } else{
            balance -= moneyUsed;
        }
        return balance;
    }
}
