package com.nexwork.api.account.ms_nexwork_api_account.persistence;

import java.util.List;
import com.nexwork.api.account.ms_nexwork_api_account.models.WorkerEntity;

public interface WorkerDAO extends GenericInterfaceDAO<WorkerEntity, Long> {
    List<WorkerEntity> findByCompanyId(Long companyId);
}
