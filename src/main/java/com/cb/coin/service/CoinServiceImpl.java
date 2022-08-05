package com.cb.coin.service;

import com.cb.coin.entity.Coin;
import com.cb.coin.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CoinServiceImpl implements CoinService {
    private final CoinRepository coinRepository;

    public CoinServiceImpl(@Autowired final CoinRepository coinRepository) {
        this.coinRepository = coinRepository;
    }

    @Override
    public List<Coin> list() {
        return coinRepository.findAll();
    }

    @Override
    public Optional<Coin> getCoinByToken(String token) {
        return coinRepository.findCoinByToken(token);
    }

    @Override
    public Coin create(Coin coin) {
        return coinRepository.save(coin);
    }

    @Override
    public Coin update(Coin coin) {
        return coinRepository.save(coin);
    }

    @Override
    public void deleteCoin(Coin coin) {
        coinRepository.delete(coin);
    }
}
