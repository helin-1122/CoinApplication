package com.cb.coin.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class ApplicationException extends RuntimeException{
    public ApplicationException() {
    }

    public ApplicationException(final String message) {
        super(message);
    }
}
