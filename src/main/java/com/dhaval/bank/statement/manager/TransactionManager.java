package com.dhaval.bank.statement.manager;

import com.dhaval.bank.statement.io.writer.ConsoleWriter;
import com.dhaval.bank.statement.objects.Category;
import com.dhaval.bank.statement.objects.Transaction;

import java.io.Console;
import java.util.List;

public class TransactionManager {
    public void classifyTransactions(Transaction txn, List<Category> categories) {
        for(Category category: categories) {
            if(!txn.isClassified()) {
                classifyTransaction(txn, category);
            }
        }
    }

    private void classifyTransaction(Transaction txn, Category category) {
        if(category.matches(txn.getNarration())){
            txn.setClassified(true);
            category.addTransaction(txn);
        }
    }

    public void printUnclassifiedTransations(List<Transaction> txns){
        for(Transaction txn: txns){
            if(!txn.isClassified()) {
                ConsoleWriter.printTransaction(txn);
            }
        }
    }
}
