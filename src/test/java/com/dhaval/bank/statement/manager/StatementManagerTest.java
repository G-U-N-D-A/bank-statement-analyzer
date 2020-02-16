package com.dhaval.bank.statement.manager;

import com.dhaval.bank.datasource.DataSource;
import com.dhaval.bank.statement.objects.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

//TODO
public class StatementManagerTest {

    StatementManager statementManager = new StatementManager();

    @Test
    public void test_getTransactions() throws FileNotFoundException {
        String sampleTransationFileName = "test-statement.txt";
        List<Transaction> actualTxns= statementManager.getTransactions(sampleTransationFileName);
        List<Transaction> expectedTxns = DataSource.getExpectedTransactions();
        Assert.assertEquals(expectedTxns, actualTxns);
    }
}