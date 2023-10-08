package com.barokah.java.belajar.p22.java.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P03ManipulateFileTest {
    @Test
    void testFileManipulation() throws IOException {
        Path path = Path.of("file.txt");

        Files.deleteIfExists(path);
        Files.createFile(path);

        Assertions.assertTrue(Files.exists(path));

        Files.delete(path);
        Assertions.assertFalse(Files.exists(path));
    }
}
