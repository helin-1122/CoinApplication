package com.cb.coin.repository;

import com.cb.coin.entity.Coin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CoinRepository extends JpaRepository<Coin, Long> {
    Optional<Coin> findCoinByToken(String token);
}
