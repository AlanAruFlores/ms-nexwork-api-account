package com.nexwork.api.account.ms_nexwork_api_account.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexwork.api.account.ms_nexwork_api_account.models.ApplicantCompanyEntity;

public interface ApplicantCompanyRepository extends JpaRepository<ApplicantCompanyEntity, Long> {
}