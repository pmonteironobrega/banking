package com.santander.teste.banking.controllers;

import com.santander.teste.banking.dtos.AccountDTO;
import com.santander.teste.banking.dtos.AccountOperationDTO;
import com.santander.teste.banking.entities.Account;
import com.santander.teste.banking.services.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AccountController.class)
@AutoConfigureMockMvc
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveAccount() throws Exception {
        AccountDTO accountDTO = new AccountDTO();
        Account savedAccount = new Account();
        when(accountService.saveAccount(any(AccountDTO.class))).thenReturn(savedAccount);

        mockMvc.perform(post("/account/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"accountNumber\":\"123456\",\"balance\":1000,\"exclusive\":false,\"customerName\":\"John Doe\",\"birthDate\":\"2023-01-01\"}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":null,\"customerName\":null,\"exclusive\":null,\"balance\":null,\"accountNumber\":null,\"birthDate\":null}"));

        verify(accountService, times(1)).saveAccount(any(AccountDTO.class));
    }

    @Test
    public void testWithdraw() throws Exception {
        Integer id = 1;
        AccountOperationDTO withdrawDTO = new AccountOperationDTO("withdraw", BigDecimal.valueOf(500));
        AccountDTO accountDTO = new AccountDTO();
        when(accountService.withdraw(eq(id), any(AccountOperationDTO.class))).thenReturn(accountDTO);

        mockMvc.perform(put("/account/withdraw/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"operation\":\"withdraw\",\"amount\":500}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":null,\"customerName\":null,\"exclusive\":null,\"balance\":null,\"accountNumber\":null,\"birthDate\":null}"));

        verify(accountService, times(1)).withdraw(eq(id), any(AccountOperationDTO.class));
    }

    @Test
    public void testDeposit() throws Exception {
        Integer id = 1;
        AccountOperationDTO depositDTO = new AccountOperationDTO("deposit", BigDecimal.valueOf(500));
        AccountDTO accountDTO = new AccountDTO();
        when(accountService.deposit(eq(id), any(AccountOperationDTO.class))).thenReturn(accountDTO);

        mockMvc.perform(put("/account/deposit/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"operation\":\"deposit\",\"amount\":500}"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":null,\"customerName\":null,\"exclusive\":null,\"balance\":null,\"accountNumber\":null,\"birthDate\":null}"));

        verify(accountService, times(1)).deposit(eq(id), any(AccountOperationDTO.class));
    }

}
