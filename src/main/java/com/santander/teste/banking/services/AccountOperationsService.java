package com.santander.teste.banking.services;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountOperationsService {

    public BigDecimal withdraw(BigDecimal balance, BigDecimal amount, Boolean isExclusive) {
        BigDecimal balanceWithdraw = withDrawTaxes(amount, isExclusive);
        BigDecimal newBalance = balance.subtract(amount.add(balanceWithdraw));
        if(newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("Insufficient funds");
        }
        return newBalance;
    }

    public BigDecimal deposit(BigDecimal balance, BigDecimal amount) {
        return balance.add(amount);
    }

    private BigDecimal withDrawTaxes(BigDecimal amount, Boolean isExclusive) {
        if (isExclusive || amount.compareTo(new BigDecimal("100")) < 0 ) {
            return amount;
        } else if(amount.compareTo(new BigDecimal("100")) > 0 &&
                amount.compareTo(new BigDecimal("300")) <= 0) {
            return amount.multiply(new BigDecimal("0.004"));
        } else {
            return amount.multiply(new BigDecimal("0.01"));
        }
    }
}
