package com.barokah.java.belajar.p20.lombok;

import com.barokah.java.belajar.p20.lombok.sneakythrow.FileHelper;
import org.junit.jupiter.api.Test;

// @SneakyThrows will throw exception automatically. So we do not need to catch or throw the exception manually.
public class P11SneakyThrowsTest {

    @Test
    void testSneakyThrows(){
        System.out.println(FileHelper.loadFile("pom.xml"));
    }
}
