package com.nexwork.api.account.ms_nexwork_api_account.utils;

import java.util.List;

import com.nexwork.api.account.ms_nexwork_api_account.models.GeolocationEntity;

public class GeolocationDataHelper {

    public static List<GeolocationEntity> getGeolocations(){
        return List.of(
            GeolocationEntity.builder()
                .id(1L)
                .lat(40.7128f)
                .ln(-74.0060f)
                .build(),
            GeolocationEntity.builder()
                .id(2L)
                .lat(34.0522f)
                .ln(-118.2437f)
                .build(),
            GeolocationEntity.builder()
                .id(3L)
                .lat(51.5074f)
                .ln(-0.1278f)
                .build(),
            GeolocationEntity.builder()
                .id(4L)
                .lat(48.8566f)
                .ln(2.3522f)
                .build(),
            GeolocationEntity.builder()
                .id(5L)
                .lat(35.6895f)
                .ln(139.6917f)
                .build()
        );
    }
}
