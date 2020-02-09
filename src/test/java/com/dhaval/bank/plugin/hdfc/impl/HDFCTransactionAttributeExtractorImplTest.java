package com.dhaval.bank.plugin.hdfc.impl;

import com.dhaval.bank.plugin.hdfc.api.HDFCTransactionAttributeExtractor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HDFCTransactionAttributeExtractorImplTest {

    String sampleRawEntry = "02/04/19  ,ATW-416021XXXXXX2288-S1ANBU74-BANGALORE-URB                                                                              ,02/04/19 ,       2000.00     ,          23.00     ,0000000000003175       ,     84404.50";
    String sampleRawEntry_withComma = "03/04/19  ,3NEFT DR-ICIC0000008-SRINIVAS VUPALLA-NETBANK, 3MUM-N093190792254401-RENT                                                  ,03/04/19 ,       3000.00     ,          33.00     ,3000000000003175       ,     34404.50";

    HDFCTransactionAttributeExtractor hdfcTransactionAttributeExtractor;
    HDFCTransactionAttributeExtractor hdfcTransactionAttributeExtractorWithComma;

    @Before
    public void setUp() {
        hdfcTransactionAttributeExtractor = new HDFCTransactionAttributeExtractorImpl(sampleRawEntry);
        hdfcTransactionAttributeExtractorWithComma = new HDFCTransactionAttributeExtractorImpl(sampleRawEntry_withComma);
    }

    @Test
    public void test_getClosingBalance() {
        Assert.assertEquals(84404.50, hdfcTransactionAttributeExtractor.getClosingBalance(), 0);
    }

    @Test
    public void test_getClosingBalance_withComma() {
        Assert.assertEquals(34404.50, hdfcTransactionAttributeExtractorWithComma.getClosingBalance(), 0);
    }

    @Test
    public void getDepositAmount() {
        Assert.assertEquals(23.0, hdfcTransactionAttributeExtractor.getDepositAmount(), 0);
    }

    @Test
    public void getDepositAmount_withComma() {
        Assert.assertEquals(33.0, hdfcTransactionAttributeExtractorWithComma.getDepositAmount(), 0);
    }

    @Test
    public void getWithdrawalAmount() {
        Assert.assertEquals(2000.0, hdfcTransactionAttributeExtractor.getWithdrawalAmount(), 0);
    }

    @Test
    public void getWithdrawalAmount_withComma() {
        Assert.assertEquals(3000.0, hdfcTransactionAttributeExtractorWithComma.getWithdrawalAmount(), 0);
    }

    @Test
    public void getNarrationNumber() {
        Assert.assertEquals("0000000000003175", hdfcTransactionAttributeExtractor.getNarrationNumber());
    }

    @Test
    public void getNarrationNumber_withComma() {
        Assert.assertEquals("3000000000003175", hdfcTransactionAttributeExtractorWithComma.getNarrationNumber());
    }

    @Test
    public void getNarration() {
        Assert.assertEquals("ATW-416021XXXXXX2288-S1ANBU74-BANGALORE-URB", hdfcTransactionAttributeExtractor.getNarration());
    }

    @Test
    public void getNarration_withComma() {
        Assert.assertEquals("3NEFT DR-ICIC0000008-SRINIVAS VUPALLA-NETBANK, 3MUM-N093190792254401-RENT", hdfcTransactionAttributeExtractorWithComma.getNarration());
    }

    @Test
    public void getDate() {
        Assert.assertEquals("02/04/19", hdfcTransactionAttributeExtractor.getDate());
    }

    @Test
    public void getDate_withComma() {
        Assert.assertEquals("03/04/19", hdfcTransactionAttributeExtractorWithComma.getDate());
    }
}
