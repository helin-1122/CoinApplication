package com.cb.coin.controller;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class CoinControllerTest {
    @Autowired
    WebTestClient client;

    @Test
    void testListCoins() {
        client.get()
                .uri("/coins")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                    .jsonPath("$.[0].token").isEqualTo("USD")
                    .jsonPath("$.[1].token").isEqualTo("GBP")
                    .jsonPath("$.[2].token").isEqualTo("EUR");
    }

    @Test
    void testGetCoinByToken() {
        client.get()
                .uri("/coins/USD")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$..token").isEqualTo("USD")
                .jsonPath("$..chineseName").isEqualTo("美金");
    }

    @Test
    void testCreateCoin() {
        val body = "{\"token\":\"NTD\",\"chineseName\":\"新台幣\"}";

        client.post()
                .uri("/coins")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(body))
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$.token").isEqualTo("NTD")
                .jsonPath("$.chineseName").isEqualTo("新台幣");
    }


    @Test
    void testUpdateCoin() {
        val body = "{\"chineseName\":\"新美金\"}";

        client.put()
                .uri("/coins/USD")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(body))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.chineseName").isEqualTo("新美金");
    }


    @Test
    void testDeleteCoin() {
        client.delete()
                .uri("/coins/USD")
                .exchange()
                .expectStatus().isNoContent();

        // verify coin is not found after delete
        client.get()
                .uri("/coin/USD")
                .exchange()
                .expectStatus().isNotFound()
                .expectBody()
                .jsonPath("$.code").isEqualTo("NOT_FOUND");
    }
}
