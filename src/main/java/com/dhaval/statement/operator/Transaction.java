package com.dhaval.statement.operator;

public class Transaction {
    private String date;
    private String narration;
    private String chequeOrNarrationNumber;
    private long withdrawalAmount;
    private long depositAmount;
    private long closingBalance;

    public Transaction(String date, String narration, String chequeOrNarrationNumber, long withdrawalAmount, long depositAmount, long closingBalance) {
        this.date = date;
        this.narration = narration;
        this.chequeOrNarrationNumber = chequeOrNarrationNumber;
        this.withdrawalAmount = withdrawalAmount;
        this.depositAmount = depositAmount;
        this.closingBalance = closingBalance;
    }

    public String getDate() {
        return date;
    }

    public String getNarration() {
        return narration;
    }

    public String getChequeOrNarrationNumber() {
        return chequeOrNarrationNumber;
    }

    public long getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public long getDepositAmount() {
        return depositAmount;
    }

    public long getClosingBalance() {
        return closingBalance;
    }
}
