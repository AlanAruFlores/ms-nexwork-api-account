package com.nexwork.api.account.ms_nexwork_api_account.service.impl;

import com.nexwork.api.account.ms_nexwork_api_account.service.AccountService;
import com.nexwork.api.account.ms_nexwork_api_account.utils.Converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

import com.nexwork.api.account.ms_nexwork_api_account.persistence.ApplicantCompanyDAO;
import com.nexwork.api.account.ms_nexwork_api_account.persistence.SupplierCompanyDAO;
import com.nexwork.api.account.ms_nexwork_api_account.persistence.WorkerDAO;
import com.nexwork.api.account.ms_nexwork_api_account.persistence.repository.CommentaryRepository;

import lombok.extern.slf4j.Slf4j;

import com.nexwork.api.account.ms_nexwork_api_account.dto.request.MetricRequestDto;
import com.nexwork.api.account.ms_nexwork_api_account.dto.response.SupplierResponseDto;
import com.nexwork.api.account.ms_nexwork_api_account.dto.response.WorkerResponseDto;
import com.nexwork.api.account.ms_nexwork_api_account.models.ApplicantCompanyEntity;
import com.nexwork.api.account.ms_nexwork_api_account.models.CommentaryEntity;
import com.nexwork.api.account.ms_nexwork_api_account.models.SupplierCompanyEntity;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService {

    private final SupplierCompanyDAO supplierCompanyDAO;
    private final WorkerDAO workerDAO;
    private final CommentaryRepository commentaryRepository;
    private final ApplicantCompanyDAO applicantCompanyDAO;


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

    @Override
    public void updateSupplierMetrics(Long supplierId, MetricRequestDto metrics) {
        SupplierCompanyEntity supplier = supplierCompanyDAO.findById(supplierId);
        supplier.setCommentsCount(supplier.getCommentsCount() + 1);
        supplier.setAvgPrice(calculateAvgPrice(supplier, metrics.getPrice()));
        supplier.setScore(calculateAvgScore(supplier, metrics.getScore()));

        ApplicantCompanyEntity applicant = applicantCompanyDAO.findById(metrics.getApplicantId());

        CommentaryEntity commentaryEntity = CommentaryEntity.builder()
            .comment(metrics.getComment())
            .score(metrics.getScore())
            .supplierCompany(supplier)
            .applicantCompany(applicant)
            .build();

        // Save the commentary first
        commentaryEntity = commentaryRepository.save(commentaryEntity);

        supplierCompanyDAO.save(supplier);
    }

    private Float calculateAvgPrice(SupplierCompanyEntity supplier, Integer price) {
        float currentTotal = supplier.getAvgPrice() * (supplier.getCommentsCount()-1);
        float newTotal = currentTotal + price;
        return newTotal / supplier.getCommentsCount();
    }
    
    private Float calculateAvgScore(SupplierCompanyEntity supplier, Double score) {
        float currentTotal = supplier.getScore() * (supplier.getCommentsCount()-1);
        float newTotal = currentTotal + score.floatValue();
        return newTotal / supplier.getCommentsCount();
    }
    
}
