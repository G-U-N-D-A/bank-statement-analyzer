package com.dhaval.bank.statement.manager;

import com.dhaval.bank.statement.objects.Category;
import com.dhaval.bank.statement.objects.Transaction;

import java.util.List;

public class TransactionManager {
    public void classifyTransactions(Transaction txn, List<Category> categories) {
        for(Category category: categories) {
            classifyTransaction(txn, category);
        }
    }

    private void classifyTransaction(Transaction txn, Category category) {
        if(category.matches(txn.getNarration())){
            txn.setClassified(true);
            category.addTransaction(txn);
        }
    }

}
