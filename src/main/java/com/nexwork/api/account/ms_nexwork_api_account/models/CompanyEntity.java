package com.nexwork.api.account.ms_nexwork_api_account.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
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