package com.nexwork.api.account.ms_nexwork_api_account.models;

import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@MappedSuperclass
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class CompanyEntity extends UserEntity {

    @OneToOne
    @JoinColumn(name = "geolocation_id")
    private GeolocationEntity geolocation;

    private Boolean isVerified;
    private String description;
}