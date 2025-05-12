package com.nexwork.api.account.ms_nexwork_api_account.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="commentary")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentaryEntity {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private Double score;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private SupplierCompanyEntity supplierCompany;

    @OneToOne
    @JoinColumn(name = "applicant_id")
    private ApplicantCompanyEntity applicantCompany;
}