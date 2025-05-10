package com.nexwork.api.account.ms_nexwork_api_account.dto;
import lombok.Data;

@Data
public class WorkerResponseDto {
    private Long id;
    private String name;
    private String email;
    private String phone;   
    private String address;
    private SupplierResponseDto company;
}
