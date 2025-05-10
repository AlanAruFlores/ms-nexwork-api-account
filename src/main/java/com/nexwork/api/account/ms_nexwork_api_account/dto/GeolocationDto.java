package com.nexwork.api.account.ms_nexwork_api_account.dto;

import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GeolocationDto {
    private Long id;
    private Float lat;
    private Float ln;
} 