package com.barokah.java.belajar.p22.java.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P04DirectoryTest {
    @Test
    void testCreateDirectory() throws IOException {
        Path path = Path.of("contoh"); // single path

        Files.createDirectory(path);

        Assertions.assertTrue(Files.exists(path));
        Assertions.assertTrue(Files.isDirectory(path));

        Files.delete(path);

        Assertions.assertFalse(Files.exists(path));
    }

    @Test
    void testCreateDirectores() throws IOException {
        Path path = Path.of("contoh/java/io"); // many path

        Files.createDirectories(path);

        Assertions.assertTrue(Files.exists(path));
        Assertions.assertTrue(Files.isDirectory(path));

        Files.delete(path);

        Assertions.assertFalse(Files.exists(path));
    }
}
