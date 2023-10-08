package com.barokah.java.belajar.p21.resilience4j;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.function.Supplier;

// every module ( retry, rate limiter, time limiter) has metrics.
// metric is information about module.

@Slf4j
public class P18MetricTest {

    private String hello() {
        log.info("hello");
        throw new IllegalArgumentException("Ups");
    }

    @Test
    void testMetric() {

        Retry retry = Retry.of("test", RetryConfig.custom()
                .maxAttempts(5)
                .waitDuration(Duration.ofSeconds(1))
                .build());


        try {
            Supplier<String> supplier = Retry.decorateSupplier(retry, this::hello);
            supplier.get();
        }catch (Exception e){
            System.out.println(retry.getMetrics().getNumberOfFailedCallsWithoutRetryAttempt());
            System.out.println(retry.getMetrics().getNumberOfFailedCallsWithRetryAttempt());
            System.out.println(retry.getMetrics().getNumberOfSuccessfulCallsWithoutRetryAttempt());
            System.out.println(retry.getMetrics().getNumberOfSuccessfulCallsWithRetryAttempt());
        }
    }
}
