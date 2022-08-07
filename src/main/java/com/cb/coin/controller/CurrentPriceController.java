package com.cb.coin.controller;

import com.cb.coin.domain.CurrentPrice;
import com.cb.coin.service.BpiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Provides current price information from conindesk
 */
@RestController()
@RequestMapping("/currentPrice")
public class CurrentPriceController {
    private final BpiService bpiService;

    public CurrentPriceController(@Autowired final BpiService bpiService) {
        this.bpiService = bpiService;
    }

    @GetMapping()
    CurrentPrice getCurrentPrice() {
        return bpiService.getCurrentPrice();
    }
}
