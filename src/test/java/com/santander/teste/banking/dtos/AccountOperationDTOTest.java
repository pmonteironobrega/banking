package com.santander.teste.banking.dtos;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AccountOperationDTOTest {

    @Test
    public void testConstructorAndGetters() {
        String operation = "deposit";
        BigDecimal amount = BigDecimal.valueOf(1000);
        AccountOperationDTO accountOperationDTO = new AccountOperationDTO(operation, amount);

        assertEquals(operation, accountOperationDTO.getOperation());
        assertEquals(amount, accountOperationDTO.amount);
    }

    @Test
    public void testSetOperation() {
        AccountOperationDTO accountOperationDTO = new AccountOperationDTO();

        accountOperationDTO.setOperation("WITHDRAW");

        assertEquals("withdraw", accountOperationDTO.getOperation());
    }
}