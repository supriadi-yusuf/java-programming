package com.barokah.java.belajar.p20.lombok;

// p20lombok support several logs. one of them is @Slf4j.
// if we use it on a class so field log will be created by p20lombok for the class and we can use it.
// the class will become a logger's name

import com.barokah.java.belajar.p20.lombok.log.FileHelper;
import org.junit.jupiter.api.Test;

public class P12LogTest {
    @Test
    void testLog(){
        System.out.println(  FileHelper.loadFile("pom.xml"));
    }
}
