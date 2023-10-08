package com.barokah.java.belajar.p22.java.io;

// flush is to force system to store data into disk

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class P09OutputStream {
    @Test
    void testWriteOneByte() {
        Path path = Path.of("output-per-one-byte.txt");
        try (OutputStream outputStream = Files.newOutputStream(path);) {
            for (int i = 1; i <= 20; i++) {

                byte[] bytes = "Hello World\n".getBytes();

                for (int j = 0; j < bytes.length; j++) {
                    outputStream.write(bytes[j]);
                }
                outputStream.flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            Assertions.fail(e);
        }
    }

    @Test
    void testWriteSeveralBytes() {
        Path path = Path.of("outputSeveralBytes.txt");
        try (OutputStream outputStream = Files.newOutputStream(path);) {
            for (int i = 1; i <= 20; i++) {
                outputStream.write("Hello World\n".getBytes());
                outputStream.flush();
            }
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

}
