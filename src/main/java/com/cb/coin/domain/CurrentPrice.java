package com.cb.coin.domain;

import lombok.Data;

import java.util.Map;

@Data
public class CurrentPrice {
    private Time time;
    private String disclaimer;
    private String chartName;
    private Map<String, BpiDetail> bpi;
}
