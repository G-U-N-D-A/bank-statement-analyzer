package com.dhaval.bank.statement.objects;

import com.dhaval.bank.constants.Constants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Category {
    private String name;
    private List<String> classifier;
    private List<Transaction> transactionList;
    private List<Transaction> withdrawals;
    private List<Transaction> deposits;
    private float withdrawnAmount;
    private float depositedAmount;

    public Category(String name, String classifier) {
        this.name = name;
        this.classifier = Arrays.asList(classifier.split(","));
    }

    public String getName() {
        return name;
    }

    public List<String> getClassifier() {
        return classifier;
    }

    public void addTransaction(Transaction transaction) {
        if(transactionList == null) {
            transactionList = new ArrayList<>();
        }
        transactionList.add(transaction);
        if(transaction.getWithdrawalAmount() > 0){
            if(withdrawals == null) {
                withdrawals = new ArrayList<>();
            }
            withdrawals.add(transaction);
            withdrawnAmount -= transaction.getWithdrawalAmount();
        } else {
            if(deposits == null) {
                deposits = new ArrayList<>();
            }
            deposits.add(transaction);
            depositedAmount += transaction.getDepositAmount();
        }
    }

    public List<Transaction> getTransactionList(){
        return transactionList;
    }

    public boolean matches(String narration) {
        boolean matched = false;
        for(String matchers: this.classifier){
            if(narration.contains(matchers)){
                matched = true;
                break;
            }
        }
        return matched;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Objects.equals(classifier, category.classifier) &&
                Objects.equals(transactionList, category.transactionList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, classifier, transactionList);
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", classifier=" + classifier +
                ", transactionList=" + transactionList +
                '}';
    }

    public List<Transaction> getWithdrawals() {
        return withdrawals;
    }

    public void setWithdrawals(List<Transaction> withdrawals) {
        this.withdrawals = withdrawals;
    }

    public List<Transaction> getDeposits() {
        return deposits;
    }

    public void setDeposits(List<Transaction> deposits) {
        this.deposits = deposits;
    }

    public float getWithdrawnAmount() {
        return withdrawnAmount;
    }

    public void setWithdrawnAmount(float withdrawnAmount) {
        this.withdrawnAmount = withdrawnAmount;
    }

    public float getDepositedAmount() {
        return depositedAmount;
    }

    public void setDepositedAmount(float depositedAmount) {
        this.depositedAmount = depositedAmount;
    }

    public void printWithdrawalAmount(){
        System.out.print(this.getDepositedAmount());
    }
    public void printDepositedAmount(){
        System.out.print(this.getWithdrawnAmount());
    }
    public void printWithdrawals(){
        for(Transaction txn: this.withdrawals){
            System.out.format("%s\t%f\t%s", txn.getNarration(), txn.getWithdrawalAmount(), txn.getDate());
        }
    }
    public void printDeposits(){
        for(Transaction txn: this.deposits){
            System.out.format("%s\t%f\t%s", txn.getNarration(), txn.getDepositAmount(), txn.getDate());
        }
    }

    public void printAllTransactions(){
        if(this.transactionList == null || this.transactionList.isEmpty()){
            System.out.println("No transactions in this category");
            return;
        }
        for(Transaction txn: this.transactionList){
            System.out.format(Constants.TRANSACTION_PRINT_FORMAT, txn.getNarration(), txn.getWithdrawalAmount(), txn.getDepositAmount(), txn.getDate());
        }
    }
}
