package com.dhaval.bank.statement.io.reader;

import com.dhaval.bank.plugin.hdfc.factory.HDFCFactory;
import com.dhaval.bank.plugin.hdfc.api.HDFCStatementValidator;
import com.dhaval.bank.statement.io.object.Transaction;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StatementReader {

    private HDFCFactory hdfcFactory;

    private HDFCStatementValidator hdfcStatmentValidator = HDFCFactory.getHDFCStatmentValidator();

    public List<Transaction> getTransactions(String fileName) throws FileNotFoundException {
        List<Transaction> txns = new ArrayList<>();

        File file = new File(getClass().getClassLoader().getResource(fileName).getFile());

        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(isValidTransactionEntry(line)) {
                txns.add(new Transaction(line.trim()));
            }
        }

        return txns;
    }

    public boolean isValidTransactionEntry(String entry) {
        return hdfcStatmentValidator.isValidTransactionEntry(entry);
    }
}
