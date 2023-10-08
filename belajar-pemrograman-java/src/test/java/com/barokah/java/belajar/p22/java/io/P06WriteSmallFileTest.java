package com.barokah.java.belajar.p22.java.io;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P06WriteSmallFileTest {
    @Test
    void testWriteBytes() throws IOException {
        Path path = Path.of("small1.txt");

        byte[] bytes = "Hello World".getBytes();
        Files.write(path, bytes);
    }

    @Test
    void testWriteText() throws IOException {
        Path path = Path.of("small2.txt");
        Files.writeString(path,"Hello World");
    }
}
