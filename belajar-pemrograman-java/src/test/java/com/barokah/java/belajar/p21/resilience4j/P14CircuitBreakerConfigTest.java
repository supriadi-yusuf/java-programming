package com.barokah.java.belajar.p21.resilience4j;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

// by default circuit breaker counts for failure rate after last 100 executions
// if failure rate is more than 50%, state will go to OPEN then automatically every request will be rejected with
// error CallNotPermittedException
// by default failure rate is based on number of execution (100)
// but we can determine if we want based on number of execution or duration


@Slf4j
public class P14CircuitBreakerConfigTest {

    public void callMe() {
        log.info("Call Me");
        throw new IllegalArgumentException("Ups");
    }

    @Test
    void testCircuitBreakerConfig() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(10f)
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                .slidingWindowSize(10)
                .minimumNumberOfCalls(10)
                .build();

        CircuitBreaker breaker = CircuitBreaker.of("test", config);

        for (int i = 1; i <= 200; i++) {
            try {
                Runnable runnable = CircuitBreaker.decorateRunnable(breaker, this::callMe);
                runnable.run();
            }catch (Exception e){
                log.info("Ups {}", e.getMessage());
            }
        }

    }
}
