package com.barokah.java.belajar.p21.resilience4j;

import io.github.resilience4j.retry.RetryRegistry;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

// registry also has event publisher

@Slf4j
public class P20EventPublisherOnRegistryTest {

    @Test
    void testEventPublisherOnRegistry(){

        RetryRegistry registry = RetryRegistry.ofDefaults();
        registry.getEventPublisher()
                .onEntryAdded(event -> log.info("Add new entry {}",event.getAddedEntry().getName()));

        registry.retry("test"); // event publisher shall be called
        registry.retry("test"); // event publisher shall not be called because test has existed already
        registry.retry("test-123"); // event publisher shall be called because test-123 does not exist
    }
}
