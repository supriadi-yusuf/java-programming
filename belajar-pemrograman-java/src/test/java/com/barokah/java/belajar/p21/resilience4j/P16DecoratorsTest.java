package com.barokah.java.belajar.p21.resilience4j;

// Decorator is to join several modules. for example : retry with rate limiter
// but decorator can not combine time limiter with other module so far

import io.github.resilience4j.decorators.Decorators;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;

@Slf4j
public class P16DecoratorsTest {

    @SneakyThrows
    public void slow() {
        log.info("Slow");
        Thread.sleep(1_000L);
        throw new IllegalArgumentException("Ups");
    }

    @Test
    void testDecorators() throws InterruptedException {
        RateLimiter limiter = RateLimiter.of("test-rateimiter", RateLimiterConfig.custom()
                .limitForPeriod(5)
                .limitRefreshPeriod(Duration.ofMinutes(1))
                .build());
        Retry retry = Retry.of("test-retry", RetryConfig.custom()
                .maxAttempts(10)
                .waitDuration(Duration.ofSeconds(2))
                .build());


        Runnable runnable = Decorators.ofRunnable(() -> slow())
                .withRetry(retry)
                .withRateLimiter(limiter)
                .decorate();

        for (int i = 1; i <= 200; i++) {
            new Thread(runnable).start();
        }

        Thread.sleep(10_000L);
    }

}
