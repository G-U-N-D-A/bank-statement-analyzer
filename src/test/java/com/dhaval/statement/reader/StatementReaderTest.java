package com.dhaval.statement.reader;

import org.junit.Assert;
import org.junit.Test;


public class StatementReaderTest {

    StatementReader stmtReader = new StatementReader();

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