package com.nexwork.api.account.ms_nexwork_api_account.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nexwork.api.account.ms_nexwork_api_account.models.CompanyTypeEntity;
import java.util.Optional;

public interface CompanyTypeRepository extends JpaRepository<CompanyTypeEntity, Long> {
    Optional<CompanyTypeEntity> findByName(String name);
}

