package com.nexwork.api.account.ms_nexwork_api_account.exceptions;

import org.springframework.http.HttpStatus;

public class InternalException extends GenericException {
    
    private static final String MESSAGE = "INTERNAL_SERVER_ERROR";
    public InternalException(String detail) {
        super(HttpStatus.INTERNAL_SERVER_ERROR.value(), MESSAGE, detail);
    }
}
