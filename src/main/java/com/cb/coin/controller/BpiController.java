package com.cb.coin.controller;

import com.cb.coin.Util.BpiResponseMapper;
import com.cb.coin.domain.BpiResponse;
import com.cb.coin.domain.CurrentPrice;
import com.cb.coin.entity.Coin;
import com.cb.coin.service.BpiService;
import com.cb.coin.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/bpis")
public class BpiController {
    private final BpiService bpiService;
    private final CoinService coinService;
    private final BpiResponseMapper mapper;

    public BpiController(@Autowired final BpiService bpiService, @Autowired final CoinService coinService, @Autowired final BpiResponseMapper mapper) {
        this.bpiService = bpiService;
        this.coinService = coinService;
        this.mapper = mapper;
    }

    @GetMapping()
    BpiResponse listBpi() {
        CurrentPrice currentPrice = bpiService.getCurrentPrice();
        List<Coin> coins = coinService.list();
        return mapper.from(currentPrice, coins);

    }
}
