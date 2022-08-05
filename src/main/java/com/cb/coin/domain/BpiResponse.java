package com.cb.coin.domain;

import lombok.Data;

import java.util.Map;

@Data
public class BpiResponse {
    String updatedTime;
    Map<String, SimplifiedBpiDetail> bpi;
}
