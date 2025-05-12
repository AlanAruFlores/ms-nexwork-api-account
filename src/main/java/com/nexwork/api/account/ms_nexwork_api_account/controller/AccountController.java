package com.nexwork.api.account.ms_nexwork_api_account.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import jakarta.validation.Valid;
import java.util.List;

import com.nexwork.api.account.ms_nexwork_api_account.dto.response.SupplierResponseDto;
import com.nexwork.api.account.ms_nexwork_api_account.dto.response.WorkerResponseDto;
import com.nexwork.api.account.ms_nexwork_api_account.dto.request.MetricRequestDto;
import com.nexwork.api.account.ms_nexwork_api_account.dto.response.MessageResponseDto;
import com.nexwork.api.account.ms_nexwork_api_account.service.AccountService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/accounts/v1/suppliers")
@RequiredArgsConstructor
@Slf4j
public class AccountController {
    
    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<List<SupplierResponseDto>> getAllSuppliers() {
        return ResponseEntity.ok(accountService.searchAllSuppliers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SupplierResponseDto> getSupplierById(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.searchSupplierById(id));
    }

    @PutMapping("/metrics/{id}")
    public ResponseEntity<MessageResponseDto> putSupplierMetrics(@PathVariable("id") Long supplierId, @RequestBody MetricRequestDto metrics) {
        accountService.updateSupplierMetrics(supplierId,metrics);
        return ResponseEntity.ok(MessageResponseDto.builder()
            .code(200)
            .message("UPDATED")
            .data(null)
            .build());
    }

    @GetMapping("/{id}/workers")
    public ResponseEntity<List<WorkerResponseDto>> getWorkersBySupplierCompanyId(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.searchWorkersBySupplierCompanyId(id));
    }
}
