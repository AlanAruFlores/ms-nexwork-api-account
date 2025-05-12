package com.nexwork.api.account.ms_nexwork_api_account.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@NoArgsConstructor
@Table(name = "applicant_companies")
@SuperBuilder
public class ApplicantCompanyEntity extends CompanyEntity {
    
}