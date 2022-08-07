package com.cb.coin.service;

import com.cb.coin.entity.Coin;
import com.cb.coin.exception.ApplicationException;
import com.cb.coin.exception.CoinAlreadyExistException;
import com.cb.coin.exception.ErrorCode;
import com.cb.coin.repository.CoinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoinServiceImpl implements CoinService {
    private static final Logger logger = LoggerFactory.getLogger(CoinServiceImpl.class);
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
        final Coin created;
        try{
            created = coinRepository.save(coin);
        } catch (DataIntegrityViolationException ex) {
            logger.error("DatatIntegrityVilation occurs: " + ex);
            throw new CoinAlreadyExistException();
        } catch (Exception ex) {
            logger.error("Error occurs when creating new coin " + ex);
            throw new ApplicationException("Error occurs when creating new coin.");
        }
        return created;
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
