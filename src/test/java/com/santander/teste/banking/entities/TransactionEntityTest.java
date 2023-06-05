package com.santander.teste.banking.entities;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.text.ParseException;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TransactionEntityTest {

    @Test
    public void testConstructorAndGetters() throws ParseException {
        String accountNumber = "123456789";
        String transactionType = "DEPOSIT";
        BigDecimal transactionValue = BigDecimal.valueOf(1000);
        Transaction transaction = new Transaction(accountNumber, transactionType, transactionValue);

        assertEquals(accountNumber, transaction.getAccountNumber());
        assertEquals(transactionType, transaction.getTransactionType());
        assertNotNull(transaction.getTransactionDate());
        assertEquals(transactionValue, transaction.getTransactionValue());
    }

    @Test
    public void testSetters() {
        Transaction transaction = new Transaction();

        transaction.setAccountNumber("123456789");
        transaction.setTransactionType("DEPOSIT");
        transaction.setTransactionDate(LocalDateTime.now().toString());
        transaction.setTransactionValue(BigDecimal.valueOf(1000));

        assertEquals("123456789", transaction.getAccountNumber());
        assertEquals("DEPOSIT", transaction.getTransactionType());
        assertNotNull(transaction.getTransactionDate());
        assertEquals(BigDecimal.valueOf(1000), transaction.getTransactionValue());
    }
}
