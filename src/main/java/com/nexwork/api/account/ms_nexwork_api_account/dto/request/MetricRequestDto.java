package com.nexwork.api.account.ms_nexwork_api_account.dto.request;

import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MetricRequestDto {
    @JsonProperty("applicant_id")
    private Long applicantId;

    private Double score;
    private String comment;
    private Integer price;

}
