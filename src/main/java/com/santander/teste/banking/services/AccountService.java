package com.santander.teste.banking.services;

import com.santander.teste.banking.dtos.AccountDTO;
import com.santander.teste.banking.dtos.AccountOperationDTO;
import com.santander.teste.banking.entities.Account;
import com.santander.teste.banking.entities.Transaction;
import com.santander.teste.banking.enums.AccountOperationEnum;
import com.santander.teste.banking.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class AccountService implements ApplicationRunner {

    private AccountRepository accountRepository;

    private AccountOperationsService accountOperationsService;

    private TransactionService transactionService;
    @Autowired
    public AccountService(AccountRepository accountRepository,
                          AccountOperationsService accountOperationsService,
                          TransactionService transactionService) {
        this.accountRepository = accountRepository;
        this.accountOperationsService = accountOperationsService;
        this.transactionService = transactionService;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }


    public Account saveAccount(AccountDTO customer) {
        Account accountEntity = new Account(customer);
        return accountRepository.save(accountEntity);
    }

    public AccountDTO withdraw(Integer id, AccountOperationDTO withdraw) {
        try {

            this.isWithdraw(withdraw);
            Account account = accountRepository.findById(id).get();
            BigDecimal newBalance = accountOperationsService.withdraw(account.getBalance(), withdraw.amount, account.getExclusive());
            account.setBalance(newBalance);
            accountRepository.save(account);
            this.transactionService.saveTransaction(new Transaction(account.getAccountNumber(),
                    AccountOperationEnum.WITHDRAW.getOperation(), withdraw.amount));

            AccountDTO accountDTO = new AccountDTO(account);
            return accountDTO;
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid operation");
        }
    }
    public AccountDTO deposit(Integer id, AccountOperationDTO deposit) {
        try {
            this.isDeposit(deposit);
            Account account = accountRepository.findById(id).get();
            BigDecimal newBalance = accountOperationsService.deposit(account.getBalance(), deposit.amount);
            account.setBalance(newBalance);
            accountRepository.save(account);
            this.transactionService.saveTransaction(new Transaction(account.getAccountNumber(),
                    AccountOperationEnum.DEPOSIT.getOperation(), deposit.amount));
            AccountDTO accountDTO = new AccountDTO(account);
            return accountDTO;
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid operation");
        }

    }
    private void isWithdraw(AccountOperationDTO operation) {
        if(!(operation.getOperation().equals(AccountOperationEnum.WITHDRAW.getOperation())))  {
            throw new IllegalArgumentException("Invalid operation");
        }
    }
    private void isDeposit(AccountOperationDTO operation) {
        if(!(operation.getOperation().equals(AccountOperationEnum.DEPOSIT.getOperation())))  {
            throw new IllegalArgumentException("Invalid operation");
        }
    }

    @Override
    public void run(ApplicationArguments args) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAccountNumber("123456");
        accountDTO.setBalance(new BigDecimal("1000"));
        accountDTO.setExclusive(false);
        accountDTO.setCustomerName("John Doe");
        accountDTO.setBirthDate(new Date());
        this.saveAccount(accountDTO);
    }


}
