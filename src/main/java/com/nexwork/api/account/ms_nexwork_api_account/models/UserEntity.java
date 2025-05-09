package com.nexwork.api.account.ms_nexwork_api_account.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;



@MappedSuperclass // Indica que es una clase padre para las entidades que heredan de ella
@Setter
@Getter
public abstract class UserEntity {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String email;
    
    private String phone;

    private String address;
    private String cuit;
    private Boolean isActive;
}
