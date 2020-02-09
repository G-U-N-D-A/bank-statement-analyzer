package com.dhaval.bank.statement.io.object;

import java.util.Objects;

public class Transaction {
    String entry;

    public Transaction(String entry) {
        this.entry = entry;
    }

    public String getEntry() {
        return entry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(entry, that.entry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entry);
    }
}
