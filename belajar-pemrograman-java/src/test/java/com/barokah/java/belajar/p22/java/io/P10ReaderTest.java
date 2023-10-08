package com.barokah.java.belajar.p22.java.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P10ReaderTest {
    @Test
    void testReadOneByte() {
        int character;
        StringBuilder builder = new StringBuilder();

        Path path = Path.of("pom.xml");

        try (BufferedReader reader = Files.newBufferedReader(path);) {
            while ((character = reader.read()) != -1) {
                builder.append((char) character);
            }

            System.out.println(builder.toString());
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void testReadSeveralBytes() {

        Path path = Path.of("pom.xml");

        char[] buffer = new char[256];
        int length;
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = Files.newBufferedReader(path);) {
            while ((length = reader.read(buffer)) != -1) {
                builder.append(buffer, 0, length);
            }

            System.out.println(builder.toString());
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }
}
