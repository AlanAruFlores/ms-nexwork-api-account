package com.nexwork.api.account.ms_nexwork_api_account.persistence;

import java.util.List;
import com.nexwork.api.account.ms_nexwork_api_account.models.WorkerEntity;

public interface WorkerDAO {
    List<WorkerEntity> findAll();
    List<WorkerEntity> findByCompanyId(Long companyId);
    WorkerEntity findById(Long id);
    WorkerEntity save(WorkerEntity worker);
    void delete(Long id);
}
