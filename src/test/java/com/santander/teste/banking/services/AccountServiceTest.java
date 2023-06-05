package com.santander.teste.banking.services;

import com.santander.teste.banking.dtos.AccountDTO;
import com.santander.teste.banking.dtos.AccountOperationDTO;
import com.santander.teste.banking.entities.Account;
import com.santander.teste.banking.entities.Transaction;
import com.santander.teste.banking.enums.AccountOperationEnum;
import com.santander.teste.banking.repositories.AccountRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @Mock
    private AccountOperationsService accountOperationsService;

    @Mock
    private TransactionService transactionService;

    private AccountService accountService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        accountService = new AccountService(accountRepository, accountOperationsService, transactionService);
    }

    @Test
    public void testGetAllAccounts() {
        // Mock do repositório
        List<Account> mockAccounts = new ArrayList<>();
        mockAccounts.add(new Account());
        when(accountRepository.findAll()).thenReturn(mockAccounts);

        List<Account> accounts = accountService.getAllAccounts();

        verify(accountRepository, times(1)).findAll();

        assertEquals(mockAccounts, accounts);
    }

    @Test
    public void testSaveAccount() {
        // Mock do DTO e do repositório
        AccountDTO accountDTO = new AccountDTO();
        Account mockAccount = new Account();
        when(accountRepository.save(any(Account.class))).thenReturn(mockAccount);

        Account savedAccount = accountService.saveAccount(accountDTO);

        verify(accountRepository, times(1)).save(any(Account.class));

        assertEquals(mockAccount, savedAccount);
    }

    @Test
    public void testWithdrawWithInvalidOperation() {
        Integer id = 1;
        AccountOperationDTO invalidDTO = new AccountOperationDTO("invalid", BigDecimal.valueOf(500));

        assertThrows(IllegalArgumentException.class, () -> accountService.withdraw(id, invalidDTO));

        verify(accountRepository, never()).findById(id);
        verify(accountOperationsService, never()).withdraw(any(BigDecimal.class), any(BigDecimal.class), any(Boolean.class));
        verify(accountRepository, never()).save(any(Account.class));
        verify(transactionService, never()).saveTransaction(any(Transaction.class));
    }


    @Test
    public void testDepositWithInvalidOperation() {
        Integer id = 1;
        AccountOperationDTO invalidDTO = new AccountOperationDTO("invalid", BigDecimal.valueOf(500));

        assertThrows(IllegalArgumentException.class, () -> accountService.deposit(id, invalidDTO));

        verify(accountRepository, never()).findById(id);
        verify(accountOperationsService, never()).deposit(any(BigDecimal.class), any(BigDecimal.class));
        verify(accountRepository, never()).save(any(Account.class));
        verify(transactionService, never()).saveTransaction(any(Transaction.class));
    }
}
