package com.dhaval.bank.statement.manager;

import com.dhaval.bank.statement.objects.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

//TODO
public class StatementManagerTest {

    StatementManager statementManager = new StatementManager();

    List<Transaction> expectedTxns = new ArrayList<>();

    {
        expectedTxns.add(new Transaction("01/04/19","UPI-1000129101465-OLACABS@AXISBANK-909120443666-OLACABS","0000909120905064",148.0f,136.00f,86404.50f));
        expectedTxns.add(new Transaction("02/04/19"  ,"ATW-416021XXXXXX2288-S1ANBU74-BANGALORE-URB","0000000000003175" ,2000.00f,76.00f,84404.50f));
        expectedTxns.add(new Transaction("03/04/19"  ,"NEFT DR-ICIC0000008-SRINIVAS VUPALLA-NETBANK, MUM-N093190792254401-RENT","N093190792254401",34000.00f,45.00f,50404.50f));
    }

    @Test
    public void test_getTransactions() throws FileNotFoundException {
        String sampleTransationFileName = "test-statement.txt";
        List<Transaction> actualTxns= statementManager.getTransactions(sampleTransationFileName);
        assertSameTransactions(expectedTxns, actualTxns);
    }

    private void assertSameTransactions(List<Transaction> expected, List<Transaction> actual) {
        Assert.assertEquals(expected.size(), actual.size());
        for(Transaction expectedTxn: expected) {
            boolean found = false;
            for(Transaction actualTxn: actual){
                found = actualTxn.equals(expectedTxn);
                if(found) {
                    break;
                }
            }
            Assert.assertTrue(found);
        }
    }
}