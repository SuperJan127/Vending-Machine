package com.techelevator;

import java.math.BigDecimal;

public class Transaction {
    private BigDecimal balance = new BigDecimal(0);

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal addMoney(BigDecimal moneyAdded){
        BigDecimal zero = new BigDecimal("0");
        if(moneyAdded.compareTo(zero) == 1) {

            balance = balance.add(moneyAdded);
        }
        return balance;
    }
    public BigDecimal useMoney(BigDecimal moneyUsed){
        BigDecimal zero = new BigDecimal("0");
        if(balance.compareTo(moneyUsed) == -1){
         System.out.println("Insufficient funds, please add more money ");

        } else {
            if(moneyUsed.compareTo(zero) == 1) {
                balance = balance.subtract(moneyUsed);
            }
        }
        return balance;
    }
}
