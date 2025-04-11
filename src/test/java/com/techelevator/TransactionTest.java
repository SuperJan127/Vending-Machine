package com.techelevator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TransactionTest {
    private Transaction sut;
    @BeforeEach
    void setup() {
         sut = new Transaction();
    }
    @Test
    void addMoney_should_increase_balance(){
        BigDecimal amountToAdd = new BigDecimal("5.00");
        sut.addMoney(amountToAdd);
        BigDecimal newBalance = sut.getBalance();
        BigDecimal expected = new BigDecimal("5.00");
        assertTrue(expected.compareTo(newBalance) == 0);
    }
    @Test
    void useMoney_should_deduct_from_balance(){
        sut.addMoney(new BigDecimal("10.00"));
        BigDecimal amountToUse = new BigDecimal("4.00");
        sut.useMoney(amountToUse);
        BigDecimal balance = sut.getBalance();
        BigDecimal expected = new BigDecimal("6.00");
        assertTrue(expected.compareTo(balance) == 0);
    }
    @Test
    void addMoney_with_negative_amount(){
        BigDecimal amountToAdd = new BigDecimal("-5.00");
        sut.addMoney(amountToAdd);
        BigDecimal newBalance = sut.getBalance();
        BigDecimal expected = new BigDecimal("0");
        assertTrue(expected.compareTo(newBalance) == 0);
    }
    @Test
    void useMoney_with_negative_amount() {
        sut.addMoney(new BigDecimal("10.00"));
        BigDecimal amountToUse = new BigDecimal("-4.00");
        sut.useMoney(amountToUse);
        BigDecimal balance = sut.getBalance();
        BigDecimal expected = new BigDecimal("10.00");
        assertTrue(expected.compareTo(balance) == 0);
    }
}
