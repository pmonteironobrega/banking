package com.santander.teste.banking.dtos;

import com.santander.teste.banking.entities.Account;

import java.math.BigDecimal;
import java.util.Date;

public class AccountDTO {
    private Integer id;
    private String customerName;
    private Boolean exclusive;
    private BigDecimal balance;
    private String accountNumber;
    private Date birthDate;

    public AccountDTO() {
    }

    public AccountDTO(Account account) {
        this.customerName = account.getCustomerName();
        this.exclusive = account.getExclusive();
        this.balance = account.getBalance();
        this.accountNumber = account.getAccountNumber();
        this.birthDate = account.getBirthDate();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }



}
