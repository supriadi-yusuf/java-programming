package com.barokah.java.belajar.p21.resilience4j;

// time limiter is to limit duration of code execution
// if the execution takes longer than given duration so the execution shall be aborted
// time limiter works on Future and CompletableFuture

import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class P11TimeLimiterConfigTest {

    @SneakyThrows
    public String slow() {
        log.info("Slow ...");
        Thread.sleep(5_000L);
        return "hello";
    }

    @Test
    void testTimeLimiterConfig() throws Exception {
        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(this::slow);

        TimeLimiterConfig config = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofSeconds(10))
                .cancelRunningFuture(true)
                .build();

        TimeLimiter limiter = TimeLimiter.of("test", config);

        Callable<String> callable = TimeLimiter.decorateFutureSupplier(limiter, () -> future);

        callable.call();

    }
}
