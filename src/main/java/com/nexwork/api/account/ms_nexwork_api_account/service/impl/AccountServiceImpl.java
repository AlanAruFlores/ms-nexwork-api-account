package com.nexwork.api.account.ms_nexwork_api_account.service.impl;

import com.nexwork.api.account.ms_nexwork_api_account.service.AccountService;
import com.nexwork.api.account.ms_nexwork_api_account.utils.Converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import com.nexwork.api.account.ms_nexwork_api_account.persistence.SupplierCompanyDAO;
import com.nexwork.api.account.ms_nexwork_api_account.persistence.WorkerDAO;
import com.nexwork.api.account.ms_nexwork_api_account.dto.SupplierResponseDto;
import com.nexwork.api.account.ms_nexwork_api_account.dto.WorkerResponseDto;
import lombok.extern.slf4j.Slf4j;
import com.nexwork.api.account.ms_nexwork_api_account.models.SupplierCompanyEntity;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final SupplierCompanyDAO supplierCompanyDAO;
    private final WorkerDAO workerDAO;

    @Override
    public List<SupplierResponseDto> searchAllSuppliers() {
        return supplierCompanyDAO.findAll()
            .stream()
            .map(supplier -> Converter.convertToDto(supplier, SupplierResponseDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public SupplierResponseDto searchSupplierById(Long id) {
        SupplierCompanyEntity supplier = supplierCompanyDAO.findById(id);
        return Converter.convertToDto(supplier, SupplierResponseDto.class);
    }

    @Override
    public List<WorkerResponseDto> searchWorkersBySupplierCompanyId(Long companyId) {
        return workerDAO.findByCompanyId(companyId)
            .stream()
            .map(worker -> Converter.convertToDto(worker, WorkerResponseDto.class))
            .collect(Collectors.toList());
    }

}
