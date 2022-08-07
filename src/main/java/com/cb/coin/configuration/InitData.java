package com.cb.coin.configuration;

import com.cb.coin.entity.Coin;
import com.cb.coin.repository.CoinRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InitData {
    private static final Logger logger = LoggerFactory.getLogger(InitData.class);

    @Bean
    CommandLineRunner initDatabase(CoinRepository repository) {
        return args -> {
            logger.info("Data init: " + repository.save(new Coin("USD", "美金")));
            logger.info("Data init: " + repository.save(new Coin("GBP", "英鎊")));
            logger.info("Data init: " + repository.save(new Coin("EUR", "歐元")));
        };
    }
}
