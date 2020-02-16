package com.dhaval.bank.datasource;

import com.dhaval.bank.statement.objects.Category;
import com.dhaval.bank.statement.objects.Transaction;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    static Transaction t1 = new Transaction("01/04/19", "UPI-1000129101465-OLACABS@AXISBANK-909120443666-OLACABS", "0000909120905064", 148.0f, 136.00f, 86404.50f);
    static Transaction t2 = new Transaction("02/04/19", "ATW-416021XXXXXX2288-S1ANBU74-BANGALORE-URB", "0000000000003175", 2000.00f, 76.00f, 84404.50f);
    static Transaction t3 = new Transaction("03/04/19", "NEFT DR-ICIC0000008-SRINIVAS VUPALLA-NETBANK, MUM-N093190792254401-RENT", "N093190792254401", 34000.00f, 45.00f, 50404.50f);

    public static List<Transaction> getExpectedTransactions() {
        List<Transaction> expectedTxns = new ArrayList<>();
        expectedTxns.add(t1);
        expectedTxns.add(t2);
        expectedTxns.add(t3);
        return expectedTxns;
    }

    public static List<Category> getExpectedClassifiedCategories() {
        String ATM_WITHDRWALSS = "ATM Withdrwalss";
        String NEFT_TRANSFERS = "NEFT Transfers";
        String UPI_PAYMENTS = "UPI Payments";

        List<Category> categories = new ArrayList<>();
        Category atmWithdrawalCategory = new Category(ATM_WITHDRWALSS, "ATW-");
        atmWithdrawalCategory.addTransaction(t2);
        Category neftWithdrawalCategory = new Category(NEFT_TRANSFERS, "NEFT");
        neftWithdrawalCategory.addTransaction(t3);
        Category upiWithdrawalCategory = new Category(UPI_PAYMENTS, "UPI");
        upiWithdrawalCategory.addTransaction(t1);

        categories.add(atmWithdrawalCategory);
        categories.add(neftWithdrawalCategory);
        categories.add(upiWithdrawalCategory);
        return  categories;
    }

    public static List<Category> getExpectedCategories() {
        String ATM_WITHDRWALSS = "ATM Withdrwalss";
        String NEFT_TRANSFERS = "NEFT Transfers";
        String UPI_PAYMENTS = "UPI Payments";

        List<Category> categories = new ArrayList<>();
        Category atmWithdrawalCategory = new Category(ATM_WITHDRWALSS, "ATW-");
        Category neftWithdrawalCategory = new Category(NEFT_TRANSFERS, "NEFT");
        Category upiWithdrawalCategory = new Category(UPI_PAYMENTS, "UPI");

        categories.add(atmWithdrawalCategory);
        categories.add(neftWithdrawalCategory);
        categories.add(upiWithdrawalCategory);
        return  categories;
    }
}
