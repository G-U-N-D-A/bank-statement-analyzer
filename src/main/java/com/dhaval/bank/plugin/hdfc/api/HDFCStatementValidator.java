package com.dhaval.bank.plugin.hdfc.api;

public interface HDFCStatementValidator {
    boolean isValidTransactionEntry(String entry);
}
