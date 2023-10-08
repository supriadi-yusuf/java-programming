package com.barokah.java.belajar.p22.java.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class P12OpenOptionTest {
    @Test
    void testAppendFile() {
        Path path = Path.of("append.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(path,
                StandardOpenOption.CREATE, // for writing to file, this option is used by default
                StandardOpenOption.APPEND);) {
            writer.write("Hello World\n");
            writer.flush();
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

}
