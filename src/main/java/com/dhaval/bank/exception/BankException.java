package com.dhaval.bank.exception;

public class BankException extends Throwable{
    public BankException() {
    }

    public BankException(String message) {
        super(message);
    }

    public BankException(String message, Throwable cause) {
        super(message, cause);
    }

    public BankException(Throwable cause) {
        super(cause);
    }

    public BankException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
