package com.nexwork.api.account.ms_nexwork_api_account.persistence.impl;

import com.nexwork.api.account.ms_nexwork_api_account.persistence.WorkerDAO;
import com.nexwork.api.account.ms_nexwork_api_account.exceptions.InternalException;
import com.nexwork.api.account.ms_nexwork_api_account.exceptions.NotFoundException;
import com.nexwork.api.account.ms_nexwork_api_account.models.WorkerEntity;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.nexwork.api.account.ms_nexwork_api_account.persistence.repository.WorkerRepository;
import com.nexwork.api.account.ms_nexwork_api_account.utils.annotations.DataAccessObject;

@DataAccessObject
@RequiredArgsConstructor
@Slf4j
public class WorkerDAOImpl implements WorkerDAO {

    private final WorkerRepository repository;

    @Override
    public List<WorkerEntity> findAll() {
        try{
            return repository.findAll();
        }
        catch (Exception e) {
            throw new InternalException(e.getMessage());
        }
    }

    @Override
    public List<WorkerEntity> findByCompanyId(Long companyId) {
        try{
            List<WorkerEntity> workers = repository.findByCompanyId(companyId);
            if(workers.isEmpty()){
                throw new NotFoundException("Workers not found for the company");
            }
            return workers;
        }
        catch (NotFoundException e) {
            throw new NotFoundException(e.getDetail());
        } 
        catch (Exception e) {
            throw new InternalException(e.getMessage());
        }
    }

    @Override
    public WorkerEntity findById(Long id) {
        try{
            return repository.findById(id)
                .orElseThrow(()-> new NotFoundException("Worker not found"));
        } 
        catch (NotFoundException e) {
            throw new NotFoundException(e.getDetail());
        }
        catch (Exception e) {
            throw new InternalException(e.getMessage());
        }
    }

    @Override
    public WorkerEntity save(WorkerEntity worker) {
        try{
            return repository.save(worker);
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
