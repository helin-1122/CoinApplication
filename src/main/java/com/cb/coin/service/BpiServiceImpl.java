package com.cb.coin.service;

import com.cb.coin.configuration.InitData;
import com.cb.coin.domain.CurrentPrice;
import com.cb.coin.exception.CoindeskIntegrationException;
import com.cb.coin.exception.TokenNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Callouts to coindesk current price API to retrieve BPI and other information.
 */
@Service
public class BpiServiceImpl implements BpiService{
    private static final Logger logger = LoggerFactory.getLogger(BpiServiceImpl.class);

    private final RestTemplate restTemplate;
    private final String apiUrl;

    public BpiServiceImpl(@Autowired final RestTemplate restTemplate, @Value("${coindesk.currentprice.apiUrl}") String apiUrl){
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
    }

    @Override
    public CurrentPrice getCurrentPrice() {
        logger.info("Call out to coindesk current price API to retrieve BPI information.");
        final CurrentPrice currentPrice;
        try {
            currentPrice = restTemplate.getForObject(this.apiUrl, CurrentPrice.class);
        } catch (Exception ex) {
            logger.error("Error occurs when calling out to coindesk: " + ex);
            throw new CoindeskIntegrationException("Error occurs when calling out to coindesk.");
        }

        return currentPrice;
    }
}
