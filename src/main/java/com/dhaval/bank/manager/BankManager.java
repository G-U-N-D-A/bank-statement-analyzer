package com.dhaval.bank.manager;

import com.dhaval.bank.exception.BankManagerException;
import com.dhaval.bank.exception.CategoryManagerException;
import com.dhaval.bank.statement.manager.CategoryManager;
import com.dhaval.bank.statement.manager.StatementManager;
import com.dhaval.bank.statement.manager.TransactionManager;
import com.dhaval.bank.statement.objects.Category;
import com.dhaval.bank.statement.objects.Transaction;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BankManager {

    private final CategoryManager categoryManager = new CategoryManager();
    StatementManager statementManager = new StatementManager();
    TransactionManager transactionManager = new TransactionManager();

    public List<Transaction> getTransactions() throws FileNotFoundException {
        List<Transaction> txns;
        txns = statementManager.getTransactions();
        return txns;
    }

    public List<Category> classifyTransactions(List<Transaction> txns) throws BankManagerException {
        List<Category> categories = null;
        try {
            categories = categoryManager.getCategories();
        } catch (CategoryManagerException e) {
            throw new BankManagerException(e);
        }
        for(Transaction txn: txns) {
            if(!txn.isClassified()) {
                transactionManager.classifyTransactions(txn, categories);
            }
        }
        return categories;
    }

    public void printUnclassifiedTransations(List<Transaction> txns) {
        transactionManager.printUnclassifiedTransations(txns);
    }

    public void printCategoryWiseTransactions(List<Category> categories) {
        categoryManager.printCategoryWiseTransactions(categories);
    }
}
