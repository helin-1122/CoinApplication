package com.cb.coin.Util;

import com.cb.coin.domain.BpiDetail;
import com.cb.coin.domain.CurrentPrice;
import com.cb.coin.domain.BpiResponse;
import com.cb.coin.domain.SimplifiedBpiDetail;
import com.cb.coin.entity.Coin;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class BpiResponseMapper {

    public static final String UPDATED_TIME_PATTERN = "MMM d, yyyy HH:mm:ss 'UTC'";
    private static final String RESPONSE_TIME_PATTERN = "yyyy/MM/dd HH:mm:ss";

    public BpiResponse from(final CurrentPrice currentPrice, final List<Coin> coinList) {
        // convert Coin list to map of coin token and coin Chinese name
        Map<String, String> coinMap = coinList.stream().collect(Collectors.toMap(Coin::getToken, Coin::getChineseName));

        Map<String, SimplifiedBpiDetail> simplifiedBpiMap = populateSimplifiedBpiMap(currentPrice.getBpi(), coinMap);

        BpiResponse response = new BpiResponse();
        response.setBpi(simplifiedBpiMap);
        response.setUpdatedTime(convertTimeFormat(currentPrice.getTime().getUpdated()));
        return response;
    }

    private static Map<String, SimplifiedBpiDetail> populateSimplifiedBpiMap(Map<String, BpiDetail> bpiDetailMap, Map<String, String> coinMap) {
        Map<String, SimplifiedBpiDetail> simplifiedBpiMap = new HashMap<>();
        bpiDetailMap.forEach((k, v)-> {
            SimplifiedBpiDetail simplifiedBpiDetail = new SimplifiedBpiDetail();
            String chineseName = coinMap.get(k);
            simplifiedBpiDetail.setChineseName(chineseName);
            simplifiedBpiDetail.setCode(v.getCode());
            simplifiedBpiDetail.setRateFloat(v.getRateFloat());
            simplifiedBpiMap.put(v.getCode(), simplifiedBpiDetail);
        });
        return simplifiedBpiMap;
    }

    private String convertTimeFormat(String updatedTime) {
        LocalDateTime time = LocalDateTime.from(DateTimeFormatter.ofPattern(UPDATED_TIME_PATTERN).parse(updatedTime));
        return time.format(DateTimeFormatter.ofPattern(RESPONSE_TIME_PATTERN));
    }
}
