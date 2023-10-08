package com.barokah.java.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbsTest {
   private Logger log;

    public Logger getLogger(Class activeClass) {
        log = LoggerFactory.getLogger(activeClass);
        return log;
    }
}
