package com.nexwork.api.account.ms_nexwork_api_account.dto;

import lombok.Data;

@Data
public class ErrorResponseDto {
    private String code;
    private String message;
    private String detail;
}
