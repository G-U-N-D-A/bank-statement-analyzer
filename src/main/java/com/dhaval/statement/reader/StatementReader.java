package com.dhaval.statement.reader;

import com.dhaval.hdfc.HDFCFactory;
import com.dhaval.hdfc.api.HDFCStatementValidator;

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

        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(isValidTransactionEntry(line)) {
                txns.add(new Transaction(line));
            }
        }

        return txns;
    }

    public boolean isValidTransactionEntry(String entry) {
        return hdfcStatmentValidator.isValidTransactionEntry(entry);
    }
}
