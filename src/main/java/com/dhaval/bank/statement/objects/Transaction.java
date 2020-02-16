package com.dhaval.bank.statement.objects;

import java.util.Objects;

public class Transaction {
    private String date;
    private String narration;
    private String chequeOrNarrationNumber;
    private float withdrawalAmount;
    private float depositAmount;
    private float closingBalance;
    private boolean classified;

    public Transaction(String date, String narration, String chequeOrNarrationNumber, float withdrawalAmount, float depositAmount, float closingBalance) {
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

    public float getWithdrawalAmount() {
        return withdrawalAmount;
    }

    public float getDepositAmount() {
        return depositAmount;
    }

    public float getClosingBalance() {
        return closingBalance;
    }

    public boolean isClassified() {
        return classified;
    }

    public void setClassified(boolean classified) {
        this.classified = classified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return withdrawalAmount == that.withdrawalAmount &&
                depositAmount == that.depositAmount &&
                closingBalance == that.closingBalance &&
                Objects.equals(date, that.date) &&
                Objects.equals(narration, that.narration) &&
                Objects.equals(chequeOrNarrationNumber, that.chequeOrNarrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, narration, chequeOrNarrationNumber, withdrawalAmount, depositAmount, closingBalance);
    }
}
