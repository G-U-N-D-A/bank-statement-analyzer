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
        String [] sampleTransationFileNames = new String[] {"test-statement.txt"};
        statementManager.setStatementFileNames(sampleTransationFileNames);
        List<Transaction> actualTxns= statementManager.getTransactions();
        List<Transaction> expectedTxns = DataSource.getExpectedTransactions();
        Assert.assertEquals(expectedTxns, actualTxns);
    }
}