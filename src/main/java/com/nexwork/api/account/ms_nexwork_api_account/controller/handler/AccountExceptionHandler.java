package com.nexwork.api.account.ms_nexwork_api_account.controller.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.nexwork.api.account.ms_nexwork_api_account.dto.response.ErrorResponseDto;
import com.nexwork.api.account.ms_nexwork_api_account.exceptions.InternalException;
import com.nexwork.api.account.ms_nexwork_api_account.exceptions.NotFoundException;

@ControllerAdvice
public class AccountExceptionHandler {
    
    @ExceptionHandler(InternalException.class)
    public ResponseEntity<?> handleEmptyException(InternalException ex) {
        return ResponseEntity
        .status(ex.getCode())
        .body(ErrorResponseDto.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .detail(ex.getDetail())
                .build());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity
        .status(ex.getCode())
        .body(ErrorResponseDto.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .detail(ex.getDetail())
                .build());
    }

}
