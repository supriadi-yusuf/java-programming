package com.barokah.java.belajar.p21.resilience4j;

import io.github.resilience4j.decorators.Decorators;
import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.function.Supplier;

// fallback will be called if error happens while code is being executed
// we can use fallback with function which returns value

@Slf4j
public class P17FallbackTest {

    public String hello(){
        log.info("hello");
        throw new IllegalArgumentException("Ups...");
    }

    @Test
    void testFallback(){
        RateLimiter limiter = RateLimiter.of("test-rateimiter", RateLimiterConfig.custom()
                .limitForPeriod(5)
                .limitRefreshPeriod(Duration.ofMinutes(1))
                .build());
        Retry retry = Retry.of("test-retry", RetryConfig.custom()
                .maxAttempts(10)
                .waitDuration(Duration.ofSeconds(2))
                .build());

        Supplier<String> supplier = Decorators.ofSupplier(() -> hello())
                .withRetry(retry) // if this fails
                .withRateLimiter(limiter) // this also fails
                .withFallback(throwable -> "Hello Guest") // then execute this
                .decorate();

        System.out.println(supplier.get());
    }
}
