package com.nexwork.api.account.ms_nexwork_api_account.dto.response;

import com.couchbase.client.core.deps.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyResponseTypeDto {
    private Long id;
    private String name;
}
