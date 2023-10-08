package com.barokah.java.belajar.p21.resilience4j;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class P03RetryRegistryTest {
    @Test
    void testRetryRegistry(){
        RetryRegistry registry = RetryRegistry.ofDefaults();

        Retry retry = registry.retry("test");
        Retry retry2 = registry.retry("test");

        Assertions.assertEquals(retry,retry2);
    }

    @Test
    void testRetryRegistryConfig(){
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(5)
                .waitDuration(Duration.ofSeconds(2))
                .retryExceptions(IllegalArgumentException.class) // type of exception that we want to retry on. if it is empty, every exception will tried
//                .ignoreExceptions() // exception that we want to ignore
                .build();

        RetryRegistry registry = RetryRegistry.ofDefaults();
        registry.addConfiguration("my-config",config);

        Retry retry = registry.retry("test", "my-config");

        Runnable runnable = Retry.decorateRunnable(retry, () -> ExperimentFunction.callMe());

        runnable.run();
    }

    @Test
    void testRetryRegistryConfig2(){
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(5)
                .waitDuration(Duration.ofSeconds(2))
                .retryExceptions(IllegalArgumentException.class) // type of exception that we want to retry on. if it is empty, every exception will tried
//                .ignoreExceptions() // exception that we want to ignore
                .build();

        RetryRegistry registry = RetryRegistry.of(config);

        Retry retry = registry.retry("test");

        Runnable runnable = Retry.decorateRunnable(retry,() -> ExperimentFunction.callMe());
        runnable.run();
    }
}
