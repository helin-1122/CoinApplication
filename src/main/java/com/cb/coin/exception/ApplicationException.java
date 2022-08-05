package com.cb.coin.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApplicationException {
    private ErrorCode code;
    private String message;
}
