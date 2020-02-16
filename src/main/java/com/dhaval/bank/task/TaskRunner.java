package com.dhaval.bank.task;

import com.dhaval.bank.exception.BankManagerException;
import com.dhaval.bank.manager.BankManager;
import com.dhaval.bank.statement.io.writer.ConsoleWriter;
import com.dhaval.bank.statement.objects.Category;
import com.dhaval.bank.statement.objects.Transaction;

import java.io.FileNotFoundException;
import java.util.List;

public class TaskRunner {
    public static void main(String[] args) throws FileNotFoundException, BankManagerException {
        String fileName = "hdfc-statement.txt";
        BankManager manager = new BankManager();
        List<Transaction> txns = manager.getTransactions(fileName);
        List<Category> categories = manager.classifyTransactions(txns);

//        ConsoleWriter.printCategories(categories);
//        ConsoleWriter.printTransactions(txns);

        ConsoleWriter.printCategoryNarrations(categories);
        checkUncategoriedTransaction(txns);
    }

    private static void checkUncategoriedTransaction(List<Transaction> txns) {
        int unclassifiedTxns = 0;
        for(Transaction txn: txns){
            if(!txn.isClassified()) {
                unclassifiedTxns++;
            }
        }
        ConsoleWriter.printLine("UNCLASSIFIED TRANSACTIONS :" + unclassifiedTxns);
    }


}
