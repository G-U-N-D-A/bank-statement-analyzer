package com.dhaval.bank.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyFileReader {

    public List<String> readLines(String fileName) throws FileNotFoundException {
        List<String> inputLines = new ArrayList<String>();
        File file = new File(getClass().getClassLoader().getResource(fileName).getFile());
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            inputLines.add(line);
        }
        return inputLines;
    }
}