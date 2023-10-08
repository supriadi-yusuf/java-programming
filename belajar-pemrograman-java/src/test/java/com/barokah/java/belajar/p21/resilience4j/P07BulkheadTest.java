package com.barokah.java.belajar.p21.resilience4j;

import io.github.resilience4j.bulkhead.Bulkhead;
import io.github.resilience4j.bulkhead.ThreadPoolBulkhead;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletionStage;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Supplier;

// bulk head is to limit number of concurrent execution
// two bulkhead implementation : semaphore, fix thread pool
// if bulk head is full, it will throw BulkHeadFullException
@Slf4j
public class P07BulkheadTest {
    private final AtomicLong counter = new AtomicLong(0);

    @SneakyThrows
    private void slow() {
        long result = counter.incrementAndGet();
        log.info("Slow : {}", result);
        Thread.sleep(5_000L);
    }

    @Test
    void testSemaphore() throws InterruptedException {
        Bulkhead bulkhead = Bulkhead.ofDefaults("test");

        for (int i = 1; i <= 1_000; i++) {
            Runnable runnable = Bulkhead.decorateRunnable(bulkhead, () -> slow());
            new Thread(runnable).start();// we need thread to execute task
        }

        Thread.sleep(10_000);
    }

    @Test
    void testThreadPool(){
        // maximum thread is total core processor
        ThreadPoolBulkhead bulkhead = ThreadPoolBulkhead.ofDefaults("test");

        for (int i=1; i<=1_000; i++){
            Supplier<CompletionStage<Void>> supplier = ThreadPoolBulkhead.decorateRunnable(bulkhead, () -> slow());
            supplier.get(); // we do not need to create thread manually, task is executed already in the pool
        }
    }
}
