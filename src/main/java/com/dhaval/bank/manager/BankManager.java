package com.dhaval.bank.manager;

import com.dhaval.bank.statement.objects.Transaction;
import com.dhaval.bank.statement.manager.StatementManager;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BankManager {
    StatementManager statementManager = new StatementManager();

    public List<Transaction> getTransactions() throws FileNotFoundException {
        List<Transaction> txns = new ArrayList<>();
        String fileName = "hdfc-statement.txt";
        txns = statementManager.getTransactions(fileName);
        return txns;
    }
}