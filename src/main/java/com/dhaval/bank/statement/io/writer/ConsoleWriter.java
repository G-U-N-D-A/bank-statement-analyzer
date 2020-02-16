package com.dhaval.bank.statement.io.writer;

import com.dhaval.bank.constants.Constants;
import com.dhaval.bank.statement.objects.Category;
import com.dhaval.bank.statement.objects.Transaction;

import java.util.List;

public class ConsoleWriter {

    public static void printLine(String message) {
        print(message); printNewline();
    }
    private static void print(String message) {
        System.out.print(message);
    }

    private static void printTab() {
        System.out.print("\t\t");
    }

    private static void printNewline(){
        System.out.print("\n");
    }


    public static void printTransactions(List<Transaction> txns) {
        for(Transaction txn: txns) {
            printTransaction(txn);
        }
        print("Size is " + txns.size()); printNewline();
    }

    public static void printTransaction(Transaction txn) {
        System.out.format(Constants.TRANSACTION_PRINT_FORMAT, txn.getNarration(), txn.getWithdrawalAmount(), txn.getDepositAmount(), txn.getDate());
        System.out.println();

    }

    public static void printCategories(List<Category> categories) {
        for(Category category: categories){
            print(category.getName());
            List<Transaction> txns = category.getTransactionList();
            printTransactions(txns);
        }
    }

    public static void printCategoryWithdrawals(List<Category> categories) {
        for(Category category: categories){
            print(category.getName());
            printNewline();
            List<Transaction> withdrawals = category.getWithdrawals();
            printNarrations(withdrawals);
            printLine(" ------------------- ");
        }
    }

    public static void printNarrations(List<Transaction> txns) {
        for(Transaction txn: txns) {
            print(txn.getNarration());
            printNewline();
        }
    }

    public static void printAmountAndNarrations(List<Transaction> txns) {
        for(Transaction txn: txns) {
            print(txn.getWithdrawalAmount()+""); printTab();
            print(txn.getNarration());
            printNewline();
        }
    }

    public static void formatAndPrintAmountAndNarrations(List<Transaction> txns) {
        for(Transaction txn: txns) {
            if(txn.getWithdrawalAmount() > 0) {
                System.out.format("%-10.2f", txn.getWithdrawalAmount());
                printTab();
                print(txn.getNarration());
                printNewline();
            }
        }
    }

    public static void printCategoryAmount(List<Category> categories) {
        print("Narration");printTab();
        print("Withdrawn");printTab();
        print("Deposited");printTab();
        printNewline();
        for(Category category: categories){
            print(category.getName());printTab();
            print(category.getWithdrawnAmount() + "");printTab();
            print(category.getDepositedAmount() + "");printTab();
            printNewline();
        }
    }
}
