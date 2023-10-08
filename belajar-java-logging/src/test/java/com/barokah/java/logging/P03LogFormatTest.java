package com.barokah.java.logging;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

public class P03LogFormatTest extends AbsTest {
    @Test
    void testLogFormat() {
        Logger log = getLogger(P03LogFormatTest.class);

        // there are three forms :
        log.info("Without parameter"); // 1st form
        log.info("{} added by {} is equal to {}", 10, 20, 30); // 2nd form
        log.error("ups", new NullPointerException());
    }
}
