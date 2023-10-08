package com.barokah.java.belajar.p21.resilience4j;


import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.function.Supplier;

public class P02RetryConfigTest {
    @Test
    void testRetryConfig(){
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(5)
                .waitDuration(Duration.ofSeconds(2))
                .retryExceptions(IllegalArgumentException.class) // type of exception that we want to retry on. if it is empty, every exception will tried
//                .ignoreExceptions() // exception that we want to ignore
                .build();

        Retry retry = Retry.of("test", config);

        Supplier<String> supplier = Retry.decorateSupplier(retry, () -> ExperimentFunction.hello());
        supplier.get();
    }
}
