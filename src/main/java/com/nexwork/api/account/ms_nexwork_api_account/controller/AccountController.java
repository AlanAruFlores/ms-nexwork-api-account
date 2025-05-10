package com.nexwork.api.account.ms_nexwork_api_account.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import com.nexwork.api.account.ms_nexwork_api_account.dto.SupplierResponseDto;
import com.nexwork.api.account.ms_nexwork_api_account.dto.WorkerResponseDto;
import com.nexwork.api.account.ms_nexwork_api_account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

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

    @GetMapping("/{id}/workers")
    public ResponseEntity<List<WorkerResponseDto>> getWorkersBySupplierCompanyId(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.searchWorkersBySupplierCompanyId(id));
    }
}
