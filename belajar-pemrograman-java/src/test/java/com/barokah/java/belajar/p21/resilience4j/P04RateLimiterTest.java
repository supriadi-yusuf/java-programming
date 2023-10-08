package com.barokah.java.belajar.p21.resilience4j;

import io.github.resilience4j.ratelimiter.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicLong;

// Rate limiter is to limit the number of execution at a given time.
// if number of request is more than maximum allowed request so exception Request Not Permitted will raise

@Slf4j
public class P04RateLimiterTest {

    private final AtomicLong counter = new AtomicLong(0L);

    @Test
    void testRateLimiter() {
        RateLimiter limiter = RateLimiter.ofDefaults("test");

        for (int i = 1; i <= 10_000; i++) {
            Runnable runnable = RateLimiter.decorateRunnable(limiter, () -> {
                long result = counter.incrementAndGet();
                log.info("Result : {}", result);
            });

            runnable.run();
        }
    }
}
