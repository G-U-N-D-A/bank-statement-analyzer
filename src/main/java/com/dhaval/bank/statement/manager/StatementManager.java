package com.dhaval.bank.statement.manager;

import com.dhaval.bank.constants.Constants;
import com.dhaval.bank.statement.io.reader.StatementReader;
import com.dhaval.bank.statement.mapper.TransactionMapper;
import com.dhaval.bank.statement.io.object.Transaction;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class StatementManager {
    StatementReader statementReader = new StatementReader();
    TransactionMapper txnMapper = new TransactionMapper();
    String [] statementFileNames = Constants.STATEMENT_FILE_NAMES;

    public void setStatementFileNames(String[] statementFileNames) {
        this.statementFileNames = statementFileNames;
    }

    public List<com.dhaval.bank.statement.objects.Transaction> getTransactions() throws FileNotFoundException {
        List<com.dhaval.bank.statement.objects.Transaction> transactions = new ArrayList<>();
        for(String fileName: statementFileNames) {
            List<com.dhaval.bank.statement.objects.Transaction> stmtTxns = getTransactions(fileName);
            transactions.addAll(stmtTxns);
        }
        return transactions;
    }

    private List<com.dhaval.bank.statement.objects.Transaction> getTransactions(String fileName) throws FileNotFoundException {
        List<com.dhaval.bank.statement.objects.Transaction> convertedTxns = new ArrayList<>();
        List<Transaction> rawTxns = statementReader.getTransactions(fileName);

        for(Transaction rawTxn: rawTxns){
            com.dhaval.bank.statement.objects.Transaction txn = txnMapper.from(rawTxn);
            if(amountLiesInRange(txn)) {
                convertedTxns.add(txn);
            }
        }
        return convertedTxns;
    }

    private boolean amountLiesInRange(com.dhaval.bank.statement.objects.Transaction txn) {
        float threshHoldAmountLowerLimit = Constants.TRANSACTION_AMOUNT_THRESHHOLD_LOWER_LIMIT;
        float threshHoldAmountUpperLimit = Constants.TRANSACTION_AMOUNT_THRESHHOLD_UPPER_LIMIT;
        float amt = txn.getWithdrawalAmount() > 0 ? txn.getWithdrawalAmount(): txn.getDepositAmount();
        return threshHoldAmountLowerLimit <= amt && amt < threshHoldAmountUpperLimit;
    }
}
