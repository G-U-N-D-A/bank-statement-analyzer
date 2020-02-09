package com.dhaval.bank.statement.manager;

import com.dhaval.bank.statement.io.reader.StatementReader;
import com.dhaval.bank.statement.mapper.TransactionMapper;
import com.dhaval.bank.statement.io.object.Transaction;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StatementManager {
    StatementReader statementReader = new StatementReader();
    TransactionMapper txnMapper = new TransactionMapper();

    public List<com.dhaval.bank.statement.objects.Transaction> getTransactions(String fileName) throws FileNotFoundException {
        List<com.dhaval.bank.statement.objects.Transaction> convertedTxns = new ArrayList<>();
        List<Transaction> rawTxns = statementReader.getTransactions(fileName);

        for(Transaction rawTxn: rawTxns){
            com.dhaval.bank.statement.objects.Transaction txn = txnMapper.from(rawTxn);
            convertedTxns.add(txn);
        }
        return convertedTxns;
    }
}
