package com.cb.coin.service;

import com.cb.coin.entity.Coin;
import com.cb.coin.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface CoinService {
    public List<Coin> list();

    public Optional<Coin> getCoinByToken(String token);

    public Coin create(Coin coin);

    public Coin update(Coin coin);

    public void deleteCoin(Coin coin);
}
