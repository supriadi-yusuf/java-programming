package com.barokah.java.belajar.p22.java.io;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class P07ReadSmallFileTest {
    @Test
    void testReadSmallFileAsByte() throws IOException {
        Path path = Path.of("small1.txt");

        byte[] bytes = Files.readAllBytes(path);
        String data = new String(bytes);

        System.out.println(data);
    }

    @Test
    void testReadSmallFileText() throws IOException {
        Path path = Path.of("small1.txt");

        String data = Files.readString(path);
        System.out.println(data);
    }
}
