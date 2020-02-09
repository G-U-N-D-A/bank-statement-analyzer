package com.dhaval.bank.statement.mapper;

import com.dhaval.bank.statement.io.object.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TransactionMapperTest {

    private static final String RAW_TXN_VALID_ENTRY = "02/04/19  ,ATW-416021XXXXXX2288-S1ANBU74-BANGALORE-URB                                                                              ,02/04/19 ,       2000.00     ,          0.00     ,0000000000003175       ,     84404.50";

    Transaction sampleRawTxn;
    com.dhaval.bank.statement.objects.Transaction sampleExpectedTxn;

    TransactionMapper transactionMapper = new TransactionMapper();

    @Before
    public void setup() {
        String testRawTxnEntry = RAW_TXN_VALID_ENTRY;
        sampleRawTxn = new Transaction(testRawTxnEntry);

        String date = "02/04/19";
        String narration = "ATW-416021XXXXXX2288-S1ANBU74-BANGALORE-URB";
        String chequeOrNarrationNumber = "0000000000003175";
        float withdrawalAmount = Float.parseFloat("2000.00");
        float depositAmount = Float.parseFloat("0.00");
        float closingBalance = Float.parseFloat("84404.50");
        sampleExpectedTxn = new com.dhaval.bank.statement.objects.Transaction(date, narration, chequeOrNarrationNumber, withdrawalAmount, depositAmount, closingBalance);
    }

    @Test
    public void test_from_validObject() {
        com.dhaval.bank.statement.objects.Transaction actualTxn = transactionMapper.from(sampleRawTxn);
        Assert.assertTrue(sampleExpectedTxn.equals(actualTxn));
    }
}