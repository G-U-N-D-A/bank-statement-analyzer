package com.dhaval.bank.exception;

public class CategoryManagerException extends BankException{
    public CategoryManagerException() {
    }

    public CategoryManagerException(String message) {
        super(message);
    }

    public CategoryManagerException(String message, Throwable cause) {
        super(message, cause);
    }

    public CategoryManagerException(Throwable cause) {
        super(cause);
    }

    public CategoryManagerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
