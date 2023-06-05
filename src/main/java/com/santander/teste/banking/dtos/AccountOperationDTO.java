package com.santander.teste.banking.dtos;

import com.santander.teste.banking.enums.AccountOperationEnum;

import java.math.BigDecimal;

public class AccountOperationDTO {

    public String operation;
    public BigDecimal amount;

    public AccountOperationDTO() {
    }

    public AccountOperationDTO(String operation, BigDecimal amount) {
        this.operation = operation;
        this.amount = amount;
    }

    public String getOperation() {
        return operation.toLowerCase();
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }
}
