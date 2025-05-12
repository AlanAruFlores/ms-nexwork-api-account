package com.nexwork.api.account.ms_nexwork_api_account.service;

import java.util.List;

import com.nexwork.api.account.ms_nexwork_api_account.dto.request.MetricRequestDto;
import com.nexwork.api.account.ms_nexwork_api_account.dto.response.SupplierResponseDto;
import com.nexwork.api.account.ms_nexwork_api_account.dto.response.WorkerResponseDto;

public interface AccountService {
    List<SupplierResponseDto> searchAllSuppliers();
    SupplierResponseDto searchSupplierById(Long id);
    List<WorkerResponseDto> searchWorkersBySupplierCompanyId(Long companyId);
    void updateSupplierMetrics(Long supplierId, MetricRequestDto metrics);
}
