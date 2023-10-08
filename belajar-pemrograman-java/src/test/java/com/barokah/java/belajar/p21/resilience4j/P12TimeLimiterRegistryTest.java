package com.barokah.java.belajar.p21.resilience4j;

import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import io.github.resilience4j.timelimiter.TimeLimiterRegistry;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class P12TimeLimiterRegistryTest {

    @SneakyThrows
    public String slow(){
        log.info("Slow ...");
        Thread.sleep(5_000L);
        return "hello";
    }

    @Test
    void testTimeLimiterRegistry() throws Exception {
        TimeLimiterConfig config = TimeLimiterConfig.custom()
                .timeoutDuration(Duration.ofSeconds(10))
                .cancelRunningFuture(true)
                .build();

        TimeLimiterRegistry registry = TimeLimiterRegistry.ofDefaults();
        registry.addConfiguration("my-config",config);

        TimeLimiter limiter = registry.timeLimiter("test", "my-config");

        ExecutorService service = Executors.newSingleThreadExecutor();
        Future<String> future = service.submit(this::slow);

        Callable<String> callable = TimeLimiter.decorateFutureSupplier(limiter, () -> future);
        callable.call();

    }
}
