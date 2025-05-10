package com.nexwork.api.account.ms_nexwork_api_account.persistence;

import java.util.List;

import com.nexwork.api.account.ms_nexwork_api_account.models.SupplierCompanyEntity;

public interface SupplierCompanyDAO {
    public List<SupplierCompanyEntity> findAll();
    public SupplierCompanyEntity findById(Long id);
    public SupplierCompanyEntity save(SupplierCompanyEntity supplierCompany);
    public void delete(Long id);
}
