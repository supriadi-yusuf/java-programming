package com.barokah.java.belajar.p21.resilience4j;

// time limiter is to limit duration of code execution
// if the execution takes longer than given duration so the execution shall be aborted
// time limiter works on Future and CompletableFuture

import io.github.resilience4j.timelimiter.TimeLimiter;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class P10TimeLimiterTest {

    @SneakyThrows
    public String slow() {
        log.info("Slow ...");
        Thread.sleep(5_000L);
        return "hello";
    }

    @Test
    void testTimeLimiter() throws Exception {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(this::slow);

        TimeLimiter limiter = TimeLimiter.ofDefaults("test"); // default 1 second

        Callable<String> callable = TimeLimiter.decorateFutureSupplier(limiter, () -> future);

        callable.call();

    }
}
