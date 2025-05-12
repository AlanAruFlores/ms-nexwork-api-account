package com.nexwork.api.account.ms_nexwork_api_account.utils;

import lombok.experimental.UtilityClass;
import com.nexwork.api.account.ms_nexwork_api_account.models.ApplicantCompanyEntity;
import com.nexwork.api.account.ms_nexwork_api_account.models.GeolocationEntity;
import java.util.List;

@UtilityClass
public class ApplicantCompanyDataHelper {
    
    public static List<ApplicantCompanyEntity> getApplicantCompanyList() {
        return List.of(
            ApplicantCompanyEntity.builder()
                .id(1L)
                .name("Nexwork")
                .isVerified(true)
                .isActive(true)
                .cuit("20-12345678-9")
                .email("nx@gmail.com")
                .phone("1231231")
                .description("Nexwork is a leading technology company.")
                .address("123 Nexwork St, Tech City")
                .geolocation(GeolocationEntity.builder().lat(40.7128f).ln(-74.0060f).build())
                .build(),
            ApplicantCompanyEntity.builder()
                .id(2L)
                .name("Tech Innovators")
                .isVerified(true)
                .isActive(true)
                .cuit("20-1444444-9")
                .email("teh@gmail.com")
                .phone("12131231")
                .description("Tech Innovators is a startup focused on AI solutions.")
                .address("456 Innovation Ave, Silicon Valley")
                .geolocation(GeolocationEntity.builder().lat(37.7749f).ln(-122.4194f).build())
                .build()
        );
    }
}
