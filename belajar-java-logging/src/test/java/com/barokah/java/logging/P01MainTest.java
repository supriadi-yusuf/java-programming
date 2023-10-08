package com.barokah.java.logging;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;

public class P01MainTest extends AbsTest {


    @Test
    void testLog(){
        Logger log = getLogger(P01MainTest.class);

        log.info("Hello Logger");
        log.info("Selamat belajar java logging");
    }
}
