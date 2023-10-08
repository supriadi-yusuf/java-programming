package com.barokah.java.belajar.p22.java.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class P08inputStreamTest {
    @Test
    void testReadOneByte() {
        Path path = Path.of("pom.xml");
        try (InputStream inputStream = Files.newInputStream(path)) {
            StringBuilder builder = new StringBuilder();
            int data;

            while ((data = inputStream.read()) != -1) { // -1 means end of file has been reach , no more data to read
                builder.append((char) data);
            }

            System.out.println(builder.toString());
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void testReadSeveralBytes() {
        byte[] buffer = new byte[256];
        int length;
        StringBuilder builder = new StringBuilder();

        Path path = Path.of("pom.xml");

        try (InputStream inputStream = Files.newInputStream(path)) {
            while ((length = inputStream.read(buffer)) != -1) {
                builder.append(new String(buffer,0,length));
            }

            System.out.println(builder.toString());
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }
}
