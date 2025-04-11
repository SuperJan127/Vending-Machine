package com.techelevator;

import java.math.BigDecimal;

public class Transaction {
    private BigDecimal balance = new BigDecimal(0);

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal addMoney(BigDecimal moneyAdded){
        balance = balance.add(moneyAdded);
        return balance;
    }
    public BigDecimal useMoney(BigDecimal moneyUsed){
        if(balance.compareTo(moneyUsed) == -1){
            System.out.println("Insufficient funds, please add more money: ");
        } else{
            balance = balance.subtract(moneyUsed);
        }
        return balance;
    }
}
