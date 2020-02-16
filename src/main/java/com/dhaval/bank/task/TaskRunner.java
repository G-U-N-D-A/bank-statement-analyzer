package com.dhaval.bank.task;

import com.dhaval.bank.exception.BankManagerException;
import com.dhaval.bank.manager.BankManager;
import com.dhaval.bank.statement.objects.Category;
import com.dhaval.bank.statement.objects.Transaction;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class TaskRunner {
    private static List<Transaction> unclassified;
    private static List<Transaction> classified;

    public static void main(String[] args) throws FileNotFoundException, BankManagerException {
        BankManager manager = new BankManager();
        List<Transaction> txns = manager.getTransactions();
        List<Category> categories = manager.classifyTransactions(txns);

        checkAllTransactionsCoverered(txns);

        System.out.println("Total transaction: "+ txns.size());
        System.out.println("Classified: "+ classified.size());
        System.out.println("Unclassified: "+ unclassified.size());

        manager.printUnclassifiedTransations(txns);

        manager.printCategoryWiseTransactions(categories);
    }

    private static void checkAllTransactionsCoverered(List<Transaction> txns) {
        unclassified = getUnclassifiedTransactions(txns);
        classified = getClassifiedTransactions(txns);

        if(unclassified.size() + classified.size() != txns.size()) {
            System.out.println("Not all covered");
        } else {
            System.out.println("All statments were analysed");
        }
    }

    private static List<Transaction> getClassifiedTransactions(List<Transaction> txns) {
        List<Transaction> classified = new ArrayList<>();
        for(Transaction txn: txns){
            if(txn.isClassified()) {
                classified.add(txn);
            }
        }
        return classified;
    }

    private static List<Transaction> getUnclassifiedTransactions(List<Transaction> txns) {
        List<Transaction> unclassified = new ArrayList<>();
        for(Transaction txn: txns){
            if(!txn.isClassified()) {
                unclassified.add(txn);
            }
        }
        return unclassified;
    }

}
