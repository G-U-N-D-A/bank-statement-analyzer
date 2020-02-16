package com.dhaval.bank.statement.io.writer;

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
        System.out.print("|\t");
    }

    private static void printNewline(){
        System.out.print("\n");
    }

    public static void printTransactions(List<Transaction> txns) {
        for(Transaction txn: txns) {
            print(txn.getWithdrawalAmount() + ""); printTab();
            print(txn.getDepositAmount() + ""); printTab();
            print(txn.getNarration()); printTab();
            printNewline();
        }
        print("Size is " + txns.size()); printNewline();
    }

    public static void printCategories(List<Category> categories) {
        for(Category category: categories){
            print(category.getName());
            List<Transaction> txns = category.getTransactionList();
            printTransactions(txns);
        }
    }

    public static void printCategoryNarrations(List<Category> categories) {
        for(Category category: categories){
            print(category.getName());
            printNewline();
            List<Transaction> txns = category.getTransactionList();
            printNarrations(txns);
            printLine(" ------------------- ");
        }
    }

    public static void printNarrations(List<Transaction> txns) {
        for(Transaction txn: txns) {
            print(txn.getNarration());
            printNewline();
        }
    }
}
