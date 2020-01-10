package com.springboot.retry.exceptions;

public class CustomJobException extends Exception {

    private final String message;
    private final int retryAttempts;

    public CustomJobException(String message, int retryAttempts)
    {
        super();
        this.message = message;
        this.retryAttempts = retryAttempts;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public int getRetryAttempts() {
        return retryAttempts;
    }
}
