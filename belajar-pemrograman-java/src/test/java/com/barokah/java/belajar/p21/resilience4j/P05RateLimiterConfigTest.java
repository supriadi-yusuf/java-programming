package com.barokah.java.belajar.p21.resilience4j;

import io.github.resilience4j.ratelimiter.RateLimiter;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class P05RateLimiterConfigTest {
    private final AtomicLong counter = new AtomicLong(0);

    @Test
    void testRateLimiterConfig() {
        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitForPeriod(100) // 100 request (maximum)
                .limitRefreshPeriod(Duration.ofMinutes(1)) // in 1 minute
                .timeoutDuration(Duration.ofSeconds(2)) // if request is full, how long system must wait for next task
                .build();

        RateLimiter limiter = RateLimiter.of("test", config);

        for (int i = 1; i <= 10_000; i++) {
            Runnable runnable = RateLimiter.decorateRunnable(limiter, () -> {
                long result = counter.incrementAndGet();
                log.info("Result: {}", result);
            });

            runnable.run();
        }

    }
}
