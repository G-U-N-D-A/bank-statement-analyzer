package com.dhaval.bank.manager;

import com.dhaval.bank.datasource.DataSource;
import com.dhaval.bank.exception.BankManagerException;
import com.dhaval.bank.statement.objects.Category;
import com.dhaval.bank.statement.objects.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

//TODO
public class BankManagerTest {

    BankManager bankManager = new BankManager();
    @Test
    public void getTransactions() {
    }

    @Test
    public void classifyTransactions() throws BankManagerException {
        List<Transaction> txns = DataSource.getExpectedTransactions();
        List<Category> actualCategories = bankManager.classifyTransactions(txns);
        List<Category> expectedCategories = DataSource.getExpectedClassifiedCategories();
        Assert.assertEquals(expectedCategories, actualCategories);
    }
}