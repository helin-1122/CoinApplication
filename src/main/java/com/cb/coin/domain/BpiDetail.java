package com.cb.coin.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BpiDetail {
    private String code;
    private String symbol;
    private String rate;
    private String description;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String chineseName;
    @JsonProperty("rate_float")
    private float rateFloat;
}
