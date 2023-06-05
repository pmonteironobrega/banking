package com.santander.teste.banking.services;

import com.santander.teste.banking.entities.Transaction;
import com.santander.teste.banking.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class TransactionService {

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction saveTransaction(Transaction transaction) {
        return this.transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsByDate(String date)  {
        return this.transactionRepository.findByTransactionDate(date);
    }
}
