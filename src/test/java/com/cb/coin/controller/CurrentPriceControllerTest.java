package com.cb.coin.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class CurrentPriceControllerTest {
    @Autowired
    WebTestClient client;

    @Test
    void testGetBpis() {
        client.get()
                .uri("/currentPrice")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                    .jsonPath("$.time.updated").exists()
                    .jsonPath("$.time.updatedISO").exists()
                    .jsonPath("$.time.updateduk").exists()
                    .jsonPath("$.disclaimer").exists()
                    .jsonPath("$.chartName").exists()
                    .jsonPath("$.bpi.USD.symbol").exists()
                    .jsonPath("$.bpi.USD.rate").exists()
                    .jsonPath("$.bpi.USD.description").exists();
    }
}
