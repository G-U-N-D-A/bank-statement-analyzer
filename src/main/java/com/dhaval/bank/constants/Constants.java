package com.dhaval.bank.constants;

public class Constants {
    public final static String [] STATEMENT_FILE_NAMES = new String[] {"hdfc_fy18-19.txt", "hdfc_tofeb_20_2020.txt"};
    public final static String CATEGORIES_FILE_NAME = "categories.txt";
    public static final int TRANSACTION_NARRATION_LIMIT = 100;
    public static final String TRANSACTION_PRINT_FORMAT = "%-"+ TRANSACTION_NARRATION_LIMIT + "s\t-%-10.2f\t%-10.2f\t%s\n";
    public static final float TRANSACTION_AMOUNT_THRESHHOLD_LOWER_LIMIT = 20000;
    public static final float TRANSACTION_AMOUNT_THRESHHOLD_UPPER_LIMIT = 30000;
    public static final boolean ONLY_WITHDRAWALS = false;

    private Constants() {}
}