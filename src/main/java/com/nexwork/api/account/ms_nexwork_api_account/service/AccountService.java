package com.nexwork.api.account.ms_nexwork_api_account.service;

import java.util.List;

import com.nexwork.api.account.ms_nexwork_api_account.dto.SupplierResponseDto;
import com.nexwork.api.account.ms_nexwork_api_account.dto.WorkerResponseDto;

public interface AccountService {
    List<SupplierResponseDto> searchAllSuppliers();
    SupplierResponseDto searchSupplierById(Long id);
    List<WorkerResponseDto> searchWorkersBySupplierCompanyId(Long companyId);
}
