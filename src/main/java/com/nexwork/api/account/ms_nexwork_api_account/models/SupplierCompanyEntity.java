package com.nexwork.api.account.ms_nexwork_api_account.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import jakarta.persistence.Table;


@Entity
@Table(name = "supplier_companies")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SupplierCompanyEntity  extends CompanyEntity {
    private Float score;
    private Float avgPrice;
    private Integer commentsCount;

    @OneToOne
    @JoinColumn(name = "company_type_id")
    private CompanyTypeEntity companyType;
    
}
