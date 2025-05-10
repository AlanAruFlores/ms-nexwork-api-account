package com.nexwork.api.account.ms_nexwork_api_account.models;

import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass
@Setter
@Getter
public abstract class CompanyEntity extends UserEntity {

    @OneToOne
    @JoinColumn(name = "geolocation_id")
    private GeolocationEntity geolocation;

    private Boolean isVerified;
    private String description;
}