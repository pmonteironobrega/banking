package com.santander.teste.banking.services;

import com.santander.teste.banking.services.AccountOperationsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class AccountOperationsServiceTest {

    @Autowired
    private AccountOperationsService accountOperationsService;



    @Test
    public void testWithdrawWithInsufficientFunds() {
        BigDecimal balance = BigDecimal.valueOf(100);
        BigDecimal amount = BigDecimal.valueOf(500);
        Boolean isExclusive = true;

        assertThrows(RuntimeException.class, () -> {
            accountOperationsService.withdraw(balance, amount, isExclusive);
        });
    }

    @Test
    public void testDeposit() {
        BigDecimal balance = BigDecimal.valueOf(1000);
        BigDecimal amount = BigDecimal.valueOf(500);

        BigDecimal newBalance = accountOperationsService.deposit(balance, amount);

        assertEquals(BigDecimal.valueOf(1500), newBalance);
    }
}
