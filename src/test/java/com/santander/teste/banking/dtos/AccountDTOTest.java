package com.santander.teste.banking.dtos;

import com.santander.teste.banking.entities.Account;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class AccountDTOTest {

    @Test
    public void testConstructor() {
        // Cria uma instância de Account
        Account account = new Account();
        account.setCustomerName("John Doe");
        account.setExclusive(true);
        account.setBalance(BigDecimal.valueOf(1000));
        account.setAccountNumber("123456789");
        account.setBirthDate(new Date());

        // Cria uma instância de AccountDTO usando o construtor
        AccountDTO accountDTO = new AccountDTO(account);

        // Verifica se os valores foram copiados corretamente
        assertEquals(account.getCustomerName(), accountDTO.getCustomerName());
        assertEquals(account.getExclusive(), accountDTO.getExclusive());
        assertEquals(account.getBalance(), accountDTO.getBalance());
        assertEquals(account.getAccountNumber(), accountDTO.getAccountNumber());
        assertEquals(account.getBirthDate(), accountDTO.getBirthDate());
    }

    @Test
    public void testGettersAndSetters() {
        // Cria uma instância de AccountDTO
        AccountDTO accountDTO = new AccountDTO();

        // Define os valores usando os setters
        accountDTO.setCustomerName("John Doe");
        accountDTO.setExclusive(true);
        accountDTO.setBalance(BigDecimal.valueOf(1000));
        accountDTO.setAccountNumber("123456789");
        accountDTO.setBirthDate(new Date());

        // Verifica se os valores foram definidos corretamente e podem ser recuperados pelos getters
        assertEquals("John Doe", accountDTO.getCustomerName());
        assertEquals(true, accountDTO.getExclusive());
        assertEquals(BigDecimal.valueOf(1000), accountDTO.getBalance());
        assertEquals("123456789", accountDTO.getAccountNumber());
        assertNotNull(accountDTO.getBirthDate());
    }
}
