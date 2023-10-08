package com.barokah.java.belajar.p22.java.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

public class P02PathTest {
    @Test
    void testCreatePath() {
        Path path = Path.of("test.txt"); // create path object not file

        Assertions.assertEquals("test.txt",path.toString());
        Assertions.assertFalse(path.isAbsolute());
    }

    @Test
    void usingFiles(){
        Path path = Path.of("pom.xml");// only create path object not file

        Assertions.assertEquals("pom.xml",path.toString());
        Assertions.assertFalse(path.isAbsolute());
        Assertions.assertTrue(Files.exists(path));
    }
}
