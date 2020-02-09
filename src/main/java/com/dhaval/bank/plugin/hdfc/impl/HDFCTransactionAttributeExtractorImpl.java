package com.dhaval.bank.plugin.hdfc.impl;

import com.dhaval.bank.plugin.hdfc.api.HDFCTransactionAttributeExtractor;

public class HDFCTransactionAttributeExtractorImpl implements HDFCTransactionAttributeExtractor {
    private String date;
    private String narration;
    private String narrationNumber;
    private float withdrawalAmount;
    private float depositAmount;
    private float closingBalance;

    public HDFCTransactionAttributeExtractorImpl(String entry) {
        String[] attributes = entry.split(",");
        int attibutesSize = attributes.length;
        date = (attributes[0]).trim();
        narration = parseNarration(attributes);
        narrationNumber = (attributes[attibutesSize - 2]).trim();
        withdrawalAmount = Float.parseFloat((attributes[attibutesSize -4]).trim());
        depositAmount = Float.parseFloat((attributes[attibutesSize -3]).trim());
        closingBalance = Float.parseFloat((attributes[attibutesSize -1]).trim());
    }

    private String parseNarration(String[] attributes) {
        String narration;
        if(narrationContainsComma(attributes)) {
            narration = (attributes[1] + "," + attributes[2]).trim();
        } else {
            narration = (attributes[1]).trim();
        }
        return narration;
    }

    private boolean narrationContainsComma(String[] attributes) {
        if(attributes.length > 7){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public float getClosingBalance() {
        return closingBalance;
    }

    @Override
    public float getDepositAmount() {
        return depositAmount;
    }

    @Override
    public float getWithdrawalAmount() {
        return withdrawalAmount;
    }

    @Override
    public String getNarrationNumber() {
        return narrationNumber;
    }

    @Override
    public String getNarration() {
        return narration;
    }

    @Override
    public String getDate() {
        return date;
    }
}
