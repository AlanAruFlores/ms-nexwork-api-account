package com.nexwork.api.account.ms_nexwork_api_account.persistence.impl;

import java.util.List;
import com.nexwork.api.account.ms_nexwork_api_account.persistence.ApplicantCompanyDAO;
import com.nexwork.api.account.ms_nexwork_api_account.persistence.repository.ApplicantCompanyRepository;
import com.nexwork.api.account.ms_nexwork_api_account.persistence.repository.GeolocationRepository;
import com.nexwork.api.account.ms_nexwork_api_account.models.ApplicantCompanyEntity;
import com.nexwork.api.account.ms_nexwork_api_account.exceptions.InternalException;
import com.nexwork.api.account.ms_nexwork_api_account.exceptions.NotFoundException;
import com.nexwork.api.account.ms_nexwork_api_account.utils.annotations.DataAccessObject;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@DataAccessObject
@RequiredArgsConstructor
@Slf4j
public class ApplicantCompanyDAOImpl implements ApplicantCompanyDAO {
    
    private final ApplicantCompanyRepository repository;
    
    @Override
    public List<ApplicantCompanyEntity> findAll() {
        try {
            return repository.findAll();
        } catch (Exception e) {
            throw new InternalException(e.getMessage());
        }
    }

    @Override
    public ApplicantCompanyEntity findById(Long id) {
        try {
            return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Applicant not found"));
        } catch (NotFoundException e) {
            throw new NotFoundException(e.getDetail());
        } catch (Exception e) {
            throw new InternalException(e.getMessage());
        }
    }

    @Override
    public ApplicantCompanyEntity save(ApplicantCompanyEntity entity) {
        try {
            return repository.save(entity);
        } catch (Exception e) {
            throw new InternalException(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new InternalException(e.getMessage());
        }
    }
}
