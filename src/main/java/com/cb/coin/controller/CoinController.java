package com.cb.coin.controller;

import com.cb.coin.entity.Coin;
import com.cb.coin.exception.TokenNotFoundException;
import com.cb.coin.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("coins")
public class CoinController {
    private final CoinService coinService;

    public CoinController(@Autowired CoinService coinService) {
        this.coinService = coinService;
    }

    @GetMapping
    Iterable<Coin> listCoins() {
        return coinService.list();
    }

    @GetMapping("/{token}")
    Coin getCoinByToken(@PathVariable String token) {
        Optional<Coin> coinOptional = coinService.getCoinByToken(token);

        if(!coinOptional.isPresent()) {
            throw new TokenNotFoundException(token + " does not exist");
        }

        return coinOptional.get();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    Coin createCoin(@RequestBody Coin coin) {
        return coinService.create(coin);
    }

    @PutMapping("/{token}")
    ResponseEntity<Coin> updateCoin(@PathVariable String token,
                                     @RequestBody Coin updateRequest) {
        Optional<Coin> coinOptional = coinService.getCoinByToken(token);

        if(!coinOptional.isPresent()) {
            throw new TokenNotFoundException(token + " does not exist");
        }

        Coin originCoin = coinOptional.get();
        originCoin.setChineseName(updateRequest.getChineseName());
        Coin updatedCoin = coinService.update(originCoin);
        return new ResponseEntity<>(updatedCoin, HttpStatus.OK);
    }


    @DeleteMapping("/{token}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    void deleteCoin(@PathVariable String token) {
        Optional<Coin> coinOptional = coinService.getCoinByToken(token);
        if(coinOptional.isPresent()) {
            coinService.deleteCoin(coinOptional.get());
        }
    }

}
