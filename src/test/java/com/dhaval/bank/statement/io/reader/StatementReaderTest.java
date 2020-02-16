package com.dhaval.bank.statement.io.reader;

import com.dhaval.bank.statement.io.object.Transaction;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class StatementReaderTest {

    StatementReader stmtReader = new StatementReader();

    List<Transaction> expectedTxns = new ArrayList<>();

    {
        expectedTxns.add(new Transaction("01/04/19  ,UPI-1000129101465-OLACABS@AXISBANK-909120443666-OLACABS                                                                  ,01/04/19 ,        148.00     ,          136.00     ,0000909120905064       ,     86404.50".trim()));
        expectedTxns.add(new Transaction("02/04/19  ,ATW-416021XXXXXX2288-S1ANBU74-BANGALORE-URB                                                                              ,02/04/19 ,       2000.00     ,          76.00     ,0000000000003175       ,     84404.50".trim()));
        expectedTxns.add(new Transaction("03/04/19  ,NEFT DR-ICIC0000008-SRINIVAS VUPALLA-NETBANK, MUM-N093190792254401-RENT                                                  ,03/04/19 ,      34000.00     ,          45.00     ,N093190792254401       ,     50404.50".trim()));
    }

    @Test
    public void test_getTransactions() throws FileNotFoundException {
        String sampleTransationFileName = "test-statement.txt";
        List<Transaction> actualTxns= stmtReader.getTransactions(sampleTransationFileName);
        Assert.assertEquals(expectedTxns, actualTxns);
    }

    @Test
    public void TestIsValidTransactionEntry_validTxn() {
        String validTxn = "01/04/19  ,UPI-1000129101465-OLACABS@AXISBANK-909120443666-OLACABS                                                                  ,01/04/19 ,        148.00     ,          0.00     ,0000909120905064       ,     86404.50";
        Assert.assertTrue(stmtReader.isValidTransactionEntry(validTxn));
    }

    @Test
    public void TestIsValidTransactionEntry_invalidTxn() {
        String invalidTxn = "  Date     ,Narration                                                                                                                ,Value Dat,Debit Amount       ,Credit Amount      ,Chq/Ref Number   ,Closing Balance\n";
        Assert.assertFalse(stmtReader.isValidTransactionEntry(invalidTxn));
    }

    @Test
    public void TestIsValidTransactionEntry_BlankTxn() {
        String blankTxn = "";
        Assert.assertFalse(stmtReader.isValidTransactionEntry(blankTxn));
    }
}