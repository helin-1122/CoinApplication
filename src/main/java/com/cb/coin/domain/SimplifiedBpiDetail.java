package com.cb.coin.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class SimplifiedBpiDetail {
    private String code;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String chineseName;
    private float rateFloat;

}
