package com.barokah.java.logging;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.MDC;

public class P04MappedDiagnosticContextTest extends AbsTest {
//    https://www.slf4j.org/api/org/slf4j/MDC.html

    // MDC stored data into local thread

    @Test
    void testMDC(){
        Logger log = getLogger(P04MappedDiagnosticContextTest.class);

        // store data with key requestId into MDC
        MDC.put("requestId","request-1");

        log.info("test mdc");

        // remove stored data from MDC
        MDC.remove("requestId");
    }

    @Test
    void testMDCWithMultiThread() throws InterruptedException {

        Logger log = getLogger(P04MappedDiagnosticContextTest.class);

        for(int i=1;i<=10; i++){
            final var iCounter = i;

            new Thread(()->{
                MDC.put("requestId","req-"+iCounter);

                log.info("test MDC");

                MDC.remove("requestId");


            }).start();

            Thread.sleep(2_000);
        }
    }
}
