package com.nexwork.api.account.ms_nexwork_api_account.persistence.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import com.nexwork.api.account.ms_nexwork_api_account.persistence.SupplierCompanyDAO;
import com.nexwork.api.account.ms_nexwork_api_account.persistence.repository.SupplierCompanyRepository;
import lombok.extern.slf4j.Slf4j;

import com.nexwork.api.account.ms_nexwork_api_account.exceptions.InternalException;
import com.nexwork.api.account.ms_nexwork_api_account.exceptions.NotFoundException;
import com.nexwork.api.account.ms_nexwork_api_account.models.SupplierCompanyEntity;

import lombok.RequiredArgsConstructor;
import com.nexwork.api.account.ms_nexwork_api_account.utils.annotations.DataAccessObject;

@DataAccessObject
@RequiredArgsConstructor
@Slf4j
public class SupplierCompanyDAOImpl implements SupplierCompanyDAO {
    

    private final SupplierCompanyRepository repository;
    
    @Override
    public List<SupplierCompanyEntity> findAll() {
        try{
            List<SupplierCompanyEntity> suppliers = repository.findAll();
            return suppliers;
        } catch (Exception e) {
            throw new InternalException(e.getMessage());
        }
    }
    
    @Override
    public SupplierCompanyEntity findById(Long id) {
        try{
            return repository.findById(id)
                .orElseThrow(()-> new NotFoundException("Supplier not found"));
        } 
        catch (NotFoundException e) {
            throw new NotFoundException(e.getDetail());
        }
        catch (Exception e) {
            throw new InternalException(e.getMessage());
        }
    }
    
    @Override
    public SupplierCompanyEntity save(SupplierCompanyEntity supplierCompany) {
        try{
            return repository.save(supplierCompany);
        } catch (Exception e) {
            throw new InternalException(e.getMessage());
        }
    }
    
    @Override
    public void delete(Long id) {
        try{
            repository.deleteById(id);
        } catch (Exception e) {
            throw new InternalException(e.getMessage());
        }
    }
}