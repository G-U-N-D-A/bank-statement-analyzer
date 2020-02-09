package com.dhaval.bank.plugin.hdfc.api;

public interface HDFCTransactionAttributeExtractor {
    float getClosingBalance();

    float getDepositAmount();

    float getWithdrawalAmount();

    String getNarrationNumber();

    String getNarration();

    String getDate();
}
