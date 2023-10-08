package com.barokah.java.belajar.p21.resilience4j;

import io.github.resilience4j.retry.Retry;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

// Retry is to retry automatically if error occurs

public class P01RetryTest {

    @Test
    void testCreateNewRetry(){
        Retry retry = Retry.ofDefaults("test");

        Runnable runnable = Retry.decorateRunnable(retry, () -> ExperimentFunction.callMe());
        runnable.run();
    }

    @Test
    void testCreateRetrySupplier(){
        Retry retry = Retry.ofDefaults("test");

        Supplier<String> supplier = Retry.decorateSupplier(retry, () -> ExperimentFunction.hello());
        supplier.get();
    }
}
