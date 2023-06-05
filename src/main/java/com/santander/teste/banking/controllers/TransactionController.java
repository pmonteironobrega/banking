package com.santander.teste.banking.controllers;

import com.santander.teste.banking.entities.Transaction;
import com.santander.teste.banking.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class TransactionController {

    private TransactionService transactionService;


    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions/{date}")
    @ResponseBody
    public List<Transaction> getTransactionsByDate(@PathVariable String date) {
        return this.transactionService.getTransactionsByDate(date);
    }
}
