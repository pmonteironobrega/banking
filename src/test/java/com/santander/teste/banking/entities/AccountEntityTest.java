package com.santander.teste.banking.entities;

import com.santander.teste.banking.dtos.AccountDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AccountEntityTest {

    @Test
    public void testConstructorAndGetters() {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setCustomerName("John Doe");
        accountDTO.setExclusive(true);
        accountDTO.setBalance(BigDecimal.valueOf(1000));
        accountDTO.setAccountNumber("123456789");
        accountDTO.setBirthDate(new Date());

        Account account = new Account(accountDTO);

        assertEquals(accountDTO.getCustomerName(), account.getCustomerName());
        assertEquals(accountDTO.getExclusive(), account.getExclusive());
        assertEquals(accountDTO.getBalance(), account.getBalance());
        assertEquals(accountDTO.getAccountNumber(), account.getAccountNumber());
        assertEquals(accountDTO.getBirthDate(), account.getBirthDate());
    }

    @Test
    public void testSetters() {
        Account account = new Account();

        account.setCustomerName("John Doe");
        account.setExclusive(true);
        account.setBalance(BigDecimal.valueOf(1000));
        account.setAccountNumber("123456789");
        account.setBirthDate(new Date());

        assertEquals("John Doe", account.getCustomerName());
        assertEquals(true, account.getExclusive());
        assertEquals(BigDecimal.valueOf(1000), account.getBalance());
        assertEquals("123456789", account.getAccountNumber());
        assertNotNull(account.getBirthDate());
    }
}
