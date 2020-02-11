package com.dhaval.bank.statement.io.writer;

import com.dhaval.bank.statement.objects.Transaction;

import java.util.List;

public class ConsoleWriter {

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
}
