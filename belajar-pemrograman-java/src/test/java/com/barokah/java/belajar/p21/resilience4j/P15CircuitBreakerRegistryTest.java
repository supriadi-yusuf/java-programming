package com.barokah.java.belajar.p21.resilience4j;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class P15CircuitBreakerRegistryTest {

    public void callMe() {
        log.info("Call Me");
        throw new IllegalArgumentException("Ups");
    }

    @Test
    void testCircuitBreakerRegistry() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(10f)
                .slidingWindowType(CircuitBreakerConfig.SlidingWindowType.COUNT_BASED)
                .slidingWindowSize(10)
                .minimumNumberOfCalls(10)
                .build();

        CircuitBreakerRegistry registry = CircuitBreakerRegistry.ofDefaults();
        registry.addConfiguration("my-config", config);

        CircuitBreaker breaker = registry.circuitBreaker("test", "my-config");

        for (int i = 1; i <= 200; i++) {
            try {
                Runnable runnable = CircuitBreaker.decorateRunnable(breaker, this::callMe);
                runnable.run();
            }catch (Exception e){
                log.info("Error : {}",e.getMessage());
            }
        }
    }
}
