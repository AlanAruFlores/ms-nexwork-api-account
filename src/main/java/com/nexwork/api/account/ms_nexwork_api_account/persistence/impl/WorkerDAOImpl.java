package com.nexwork.api.account.ms_nexwork_api_account.persistence.impl;

import com.nexwork.api.account.ms_nexwork_api_account.persistence.WorkerDAO;
import com.nexwork.api.account.ms_nexwork_api_account.exceptions.InternalException;
import com.nexwork.api.account.ms_nexwork_api_account.models.WorkerEntity;

import java.util.List;

import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import com.nexwork.api.account.ms_nexwork_api_account.persistence.repository.WorkerRepository;

@Component
@RequiredArgsConstructor
@Slf4j
public class WorkerDAOImpl implements WorkerDAO {

    @Autowired
    private WorkerRepository repository;

    @Override
    public List<WorkerEntity> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public List<WorkerEntity> findByCompanyId(Long companyId) {
        try{
            return repository.findByCompanyId(companyId);
        } catch (Exception e) {
            throw new InternalException(e.getMessage());
        }
    }

    @Override
    public WorkerEntity findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public WorkerEntity save(WorkerEntity worker) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
