package com.santander.teste.banking.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private String transactionType;

    @Column(nullable = false)
    private String transactionDate;

    @Column(nullable = false)
    private BigDecimal transactionValue;

    public Transaction() {
    }

    public Transaction(String accountNumber, String transactionType, BigDecimal transactionValue) throws ParseException {
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.transactionDate = LocalDate.now().toString();
        this.transactionValue = transactionValue;
    }

    public Integer getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public BigDecimal getTransactionValue() {
        return transactionValue;
    }

    public void setTransactionValue(BigDecimal transactionValue) {
        this.transactionValue = transactionValue;
    }

}
