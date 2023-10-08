package com.barokah.java.belajar.p21.resilience4j;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExperimentFunction {

    public static void callMe() {
        log.info("Try call me");

        throw new IllegalArgumentException("error ....");
    }

    public static String hello() {
        log.info("Call say hello");

        throw new IllegalArgumentException("error say hello");
    }
}
