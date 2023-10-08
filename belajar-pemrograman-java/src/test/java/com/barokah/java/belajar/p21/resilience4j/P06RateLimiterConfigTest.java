package com.barokah.java.belajar.p21.resilience4j;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class P06RateLimiterConfigTest {
    private final AtomicLong counter = new AtomicLong(0);

    @Test
    void testRateLimiterRegistry() {
        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitForPeriod(100)
                .limitRefreshPeriod(Duration.ofMinutes(1))
                .timeoutDuration(Duration.ofSeconds(2))
                .build();

        RateLimiterRegistry registry = RateLimiterRegistry.ofDefaults();
        registry.addConfiguration("my-config", config);

        RateLimiter limiter = registry.rateLimiter("test", "my-config");

        for (int i = 1; i <= 10_000; i++) {
            Runnable runnable = RateLimiter.decorateRunnable(limiter, () -> {
                long result = counter.incrementAndGet();
                log.info("Result : {}", result);
            });

            runnable.run();
        }
    }
}
