package com.dhaval.bank.plugin.hdfc.impl;

import com.dhaval.bank.plugin.hdfc.api.HDFCStatementValidator;
import com.dhaval.bank.plugin.hdfc.impl.HDFCStatementValidatorImpl;
import org.junit.Assert;
import org.junit.Test;

public class HDFCStatementValidatorImplTest {

    HDFCStatementValidator hdfcStatementValidator = new HDFCStatementValidatorImpl();

    @Test
    public void testIsValidTransactionEntry_blankIsInValid() {
        String blankTransaction = "";
        Assert.assertFalse(hdfcStatementValidator.isValidTransactionEntry(blankTransaction));
    }

    @Test
    public void testIsValidTransactionEntry_validEntry() {
        String validTxn = "01/04/19  ,UPI-1000129101465-OLACABS@AXISBANK-909120443666-OLACABS                                                                  ,01/04/19 ,        148.00     ,          0.00     ,0000909120905064       ,     86404.50";
        Assert.assertTrue(hdfcStatementValidator.isValidTransactionEntry(validTxn));
    }

}