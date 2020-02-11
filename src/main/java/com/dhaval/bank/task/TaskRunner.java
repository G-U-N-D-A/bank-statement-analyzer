package com.dhaval.bank.task;

import com.dhaval.bank.manager.BankManager;
import com.dhaval.bank.statement.io.writer.ConsoleWriter;
import com.dhaval.bank.statement.objects.Transaction;

import java.io.FileNotFoundException;
import java.util.List;

public class TaskRunner {
    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "hdfc-statement.txt";
        BankManager manager = new BankManager();
        List<Transaction> txns = manager.getTransactions(fileName);
        ConsoleWriter.printTransactions(txns);
    }


}
