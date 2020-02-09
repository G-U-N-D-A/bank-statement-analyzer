package com.dhaval.bank.statement.mapper;

import com.dhaval.bank.plugin.hdfc.factory.HDFCFactory;
import com.dhaval.bank.plugin.hdfc.api.HDFCTransactionAttributeExtractor;
import com.dhaval.bank.statement.io.object.Transaction;

public class TransactionMapper {

    public com.dhaval.bank.statement.objects.Transaction from(Transaction rawTxn) {
        String entry = rawTxn.getEntry();
        HDFCTransactionAttributeExtractor hdfcTransactionAttributeExtractor = HDFCFactory.getHdfcTransactionAttributeExtractor(entry);
        String date = hdfcTransactionAttributeExtractor.getDate();
        String narration = hdfcTransactionAttributeExtractor.getNarration();
        String chequeOrNarrationNumber = hdfcTransactionAttributeExtractor.getNarrationNumber();
        float withdrawalAmount = hdfcTransactionAttributeExtractor.getWithdrawalAmount();
        float depositAmount = hdfcTransactionAttributeExtractor.getDepositAmount();
        float closingBalance = hdfcTransactionAttributeExtractor.getClosingBalance();

        com.dhaval.bank.statement.objects.Transaction txn = new com.dhaval.bank.statement.objects.Transaction(date, narration, chequeOrNarrationNumber, withdrawalAmount, depositAmount, closingBalance);
        return txn;
    }
}
