package com.nexwork.api.account.ms_nexwork_api_account.persistence.impl;

import com.nexwork.api.account.ms_nexwork_api_account.persistence.CompanyTypeDAO;
import com.nexwork.api.account.ms_nexwork_api_account.models.CompanyTypeEntity;

import com.nexwork.api.account.ms_nexwork_api_account.persistence.repository.CompanyTypeRepository;

import java.util.List;
import com.nexwork.api.account.ms_nexwork_api_account.exceptions.NotFoundException;
import com.nexwork.api.account.ms_nexwork_api_account.exceptions.InternalException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.nexwork.api.account.ms_nexwork_api_account.utils.annotations.DataAccessObject;

@DataAccessObject
@RequiredArgsConstructor
@Slf4j
public class CompanyTypeDAOImpl implements CompanyTypeDAO{
    
    private final CompanyTypeRepository companyTypeRepository;

    @Override
    public List<CompanyTypeEntity> findAll() {
        try{
            return companyTypeRepository.findAll();
        } catch (Exception e) {
            throw new InternalException(e.getMessage());
        }
    }

    @Override
    public CompanyTypeEntity findById(Long id) {
        try{
            return companyTypeRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Company type not found"));
        } catch (Exception e) {
            throw new InternalException(e.getMessage());
        }
    }

    @Override
    public CompanyTypeEntity save(CompanyTypeEntity entity) {
        try{
            return companyTypeRepository.save(entity);
        } catch (Exception e) {
            throw new InternalException(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try{
            companyTypeRepository.deleteById(id);
        } catch (Exception e) {
            throw new InternalException(e.getMessage());
        }
    }
}
