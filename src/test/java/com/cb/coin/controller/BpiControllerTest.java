package com.cb.coin.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
public class BpiControllerTest {
    @Autowired
    WebTestClient client;

    @Test
    void testGetBpis() {
        client.get()
                .uri("/bpis")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                    .jsonPath("$.updatedTime").exists()
                    .jsonPath("$.bpi.EUR.code").exists()
                    .jsonPath("$.bpi.EUR.chineseName").exists()
                    .jsonPath("$.bpi.EUR.rateFloat").exists()
                    .jsonPath("$.bpi.EUR.description").doesNotHaveJsonPath()
                    .jsonPath("$.bpi.EUR.symbol").doesNotHaveJsonPath();
    }
}
