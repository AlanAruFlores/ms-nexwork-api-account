package com.nexwork.api.account.ms_nexwork_api_account.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SupplierResponseDto {
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String description;
    private String type;
    private GeolocationDto geolocation;
    private Float score;
    
    @JsonProperty("avg_price")
    private Float avgPrice;

    @JsonProperty("is_verified")
    private Integer commentsCount;

    @JsonProperty("is_verified")
    private Boolean isVerified;
}
