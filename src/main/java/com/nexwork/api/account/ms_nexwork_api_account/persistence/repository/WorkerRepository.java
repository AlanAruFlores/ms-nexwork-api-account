package com.nexwork.api.account.ms_nexwork_api_account.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nexwork.api.account.ms_nexwork_api_account.models.WorkerEntity;
import java.util.List;

public interface WorkerRepository extends JpaRepository<WorkerEntity, Long> {
    List<WorkerEntity> findByCompanyId(Long companyId);
}
