package com.santander.teste.banking.enums;

public enum AccountOperationEnum {
    DEPOSIT("deposit"),
    WITHDRAW("withdraw");

    private final String operation;
    AccountOperationEnum(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}

