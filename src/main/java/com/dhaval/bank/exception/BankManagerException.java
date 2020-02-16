package com.dhaval.bank.exception;

public class BankManagerException extends BankException {
    public BankManagerException() {
    }

    public BankManagerException(String message) {
        super(message);
    }

    public BankManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    public BankManagerException(Throwable cause) {
        super(cause);
    }

    public BankManagerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
