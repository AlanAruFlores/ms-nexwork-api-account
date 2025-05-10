package com.nexwork.api.account.ms_nexwork_api_account.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "workers")
public class WorkerEntity extends UserEntity {
    
    @ManyToOne
    @JoinColumn(name = "company_id")
    private SupplierCompanyEntity company;
}
