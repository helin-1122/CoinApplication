package com.cb.coin.exception;

public class CoindeskIntegrationException extends RuntimeException{
    public CoindeskIntegrationException() {
        super();
    }

    public CoindeskIntegrationException(final String message) {
        super(message);
    }
}
