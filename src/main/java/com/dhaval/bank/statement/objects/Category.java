package com.dhaval.bank.statement.objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Category {
    private String name;
    private List<String> classifier;
    private List<Transaction> transactionList;

    public Category(String name, String classifier) {
        this.name = name;
        this.classifier = Arrays.asList(classifier.split(","));
    }

    public String getName() {
        return name;
    }

    public List<String> getClassifier() {
        return classifier;
    }

    public void addTransaction(Transaction transaction) {
        if(transactionList == null) {
            transactionList = new ArrayList<>();
        }
        transactionList.add(transaction);
    }

    public boolean matches(String narration) {
        boolean matched = false;
        for(String matchers: this.classifier){
            if(narration.contains(matchers)){
                matched = true;
                break;
            }
        }
        return matched;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Objects.equals(classifier, category.classifier) &&
                Objects.equals(transactionList, category.transactionList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, classifier, transactionList);
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", classifier=" + classifier +
                ", transactionList=" + transactionList +
                '}';
    }
}
