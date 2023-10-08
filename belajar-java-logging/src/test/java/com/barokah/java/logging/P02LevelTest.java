package com.barokah.java.logging;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
//level order : trace -> debug -> info -> warn -> error
public class P02LevelTest extends AbsTest {
    @Test
    void testLevel() throws InterruptedException {
        Logger log = getLogger(P02LevelTest.class);

        for (int i=1;i<=1_000_000;i++) {
            log.trace("Trace"); // disappear
            log.debug("Debug");
            log.info("Info");
            log.warn("Warning");
            log.error("Error");

            if (i%1_000==0){
                Thread.sleep(20);
            }
        }
    }
}
