package com.santander.teste.banking.entities;

import com.santander.teste.banking.dtos.AccountDTO;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String customerName;

    @Column(columnDefinition = "boolean default false")
    private Boolean exclusive;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(nullable = false, unique = true)
    private String accountNumber;

    @Column(nullable = false)
    private Date birthDate;

    public Account() {

    }
    public Account(AccountDTO accountDTO) {
        this.customerName = accountDTO.getCustomerName();
        this.exclusive = accountDTO.getExclusive();
        this.balance = accountDTO.getBalance();
        this.accountNumber = accountDTO.getAccountNumber();
        this.birthDate = accountDTO.getBirthDate();
    }

    public Integer getId() {
        return id;
    }
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public Boolean getExclusive() {
        return exclusive;
    }

    public void setExclusive(Boolean exclusive) {
        this.exclusive = exclusive;
    }
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
    public BigDecimal getBalance() {
        return balance;
    }
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
