package com.nexwork.api.account.ms_nexwork_api_account.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexwork.api.account.ms_nexwork_api_account.models.GeolocationEntity;

public interface GeolocationRepository extends JpaRepository<GeolocationEntity, Long> {
}
