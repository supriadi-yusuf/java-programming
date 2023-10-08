package com.barokah.java.belajar.p21.resilience4j;

import io.github.resilience4j.bulkhead.*;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

@Slf4j
public class P09BulkheadRegistryTest {
    private final AtomicLong counter = new AtomicLong(0);

    @SneakyThrows
    private void slow() {
        long result = counter.incrementAndGet();
        log.info("Slow : {}", result);
        Thread.sleep(5_000L);
    }

    @Test
    void testSemaphoreRegistry() throws InterruptedException {
        BulkheadConfig config = BulkheadConfig.custom()
                .maxConcurrentCalls(5)
                .maxWaitDuration(Duration.ofSeconds(5))
                .build();

        BulkheadRegistry registry = BulkheadRegistry.ofDefaults();
        registry.addConfiguration("my-config", config);

        Bulkhead bulkhead = registry.bulkhead("test", "my-config");

        for (int i = 1; i <= 100; i++) {
            Runnable runnable = Bulkhead.decorateRunnable(bulkhead, () -> slow());
            new Thread(runnable).start();
        }

        Thread.sleep(10_000);
    }

    @Test
    void testThreadPoolBulkheadRegistry() throws InterruptedException {
        ThreadPoolBulkheadConfig config = ThreadPoolBulkheadConfig.custom()
                .maxThreadPoolSize(5)
                .coreThreadPoolSize(5)
                .queueCapacity(1)
                .build();

        ThreadPoolBulkheadRegistry registry = ThreadPoolBulkheadRegistry.ofDefaults();
        registry.addConfiguration("my-config", config);

        ThreadPoolBulkhead bulkhead = registry.bulkhead("test", "my-config");

        for (int i = 1; i <= 100; i++) {
            Supplier<CompletionStage<Void>> supplier = ThreadPoolBulkhead.decorateRunnable(bulkhead, () -> slow());
            supplier.get();
        }

        Thread.sleep(10_000L);
    }

}
