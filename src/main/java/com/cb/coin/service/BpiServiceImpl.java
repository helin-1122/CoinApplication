package com.cb.coin.service;

import com.cb.coin.domain.CurrentPrice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BpiServiceImpl implements BpiService{

    private final RestTemplate restTemplate;
    private final String apiUrl;

    public BpiServiceImpl(@Autowired final RestTemplate restTemplate, @Value("${coindesk.currentprice.apiUrl}") String apiUrl){
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }

    @Override
    public CurrentPrice getCurrentPrice() {
        return restTemplate.getForObject(this.apiUrl, CurrentPrice.class);
    }
}
