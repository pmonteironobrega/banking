package com.santander.teste.banking.controllers;

import com.santander.teste.banking.dtos.AccountDTO;
import com.santander.teste.banking.dtos.AccountOperationDTO;
import com.santander.teste.banking.entities.Account;
import com.santander.teste.banking.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/create")
    public @ResponseBody Account saveCustomer(@RequestBody AccountDTO customer) {
        return this.accountService.saveAccount(customer);
    }

    @PutMapping("/withdraw/{id}")
    public @ResponseBody AccountDTO withdraw(@PathVariable Integer id,
                                             @RequestBody AccountOperationDTO withdraw) {
        return this.accountService.withdraw(id, withdraw);
    }

    @PutMapping("/deposit/{id}")
    public @ResponseBody AccountDTO deposit(@PathVariable Integer id,
                                            @RequestBody AccountOperationDTO deposit) {
        return this.accountService.deposit(id, deposit);
    }

    @GetMapping("/")
    @ResponseBody
    public List<AccountDTO> getAllCustomers() {
        List<Account> accounts = this.accountService.getAllAccounts();
        Iterator<Account> iterator = accounts.iterator();
        List<AccountDTO> accountDTOS = new ArrayList<>();
        while (iterator.hasNext()) {
            Account account = iterator.next();
            AccountDTO accountDTO = new AccountDTO(account);
            accountDTOS.add(accountDTO);
        }
        return accountDTOS;

    }
}
