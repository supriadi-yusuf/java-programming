package com.barokah.java.belajar.p22.java.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class P01FileTest {
    @Test
    void testCreateFile(){
        File file = new File("test.txt"); // only create file object not real file

        Assertions.assertEquals("test.txt",file.getName());
        Assertions.assertFalse(file.exists());
    }

    @Test
    void testCreateFileExists(){
        File file = new File("src/main/resources/application.properties");// only create file object not real file

        Assertions.assertEquals("application.properties",file.getName());
        Assertions.assertTrue(file.exists());
    }
}
