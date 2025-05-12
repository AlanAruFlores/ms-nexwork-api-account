package com.nexwork.api.account.ms_nexwork_api_account.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseDto {
    private Integer code;
    private String message;
    private String detail;
}
