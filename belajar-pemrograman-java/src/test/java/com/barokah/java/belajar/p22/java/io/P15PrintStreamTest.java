package com.barokah.java.belajar.p22.java.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

// PrintStream is an output stream than can receive any kind data type
// PrintStream is to write into output stream

public class P15PrintStreamTest {
    @Test
    void testPrintStreamToConsole(){
        PrintStream stream = System.out;

        stream.println("Hello World");
        stream.println("Hello World");
        stream.println("Hello World");
    }

    @Test
    void testPrintStreamToFile(){
        Path path = Path.of("print.txt");

        try (OutputStream outputStream = Files.newOutputStream(path);){
            PrintStream stream = new PrintStream(outputStream);

            stream.println("Hello World");
            stream.println("Hello World");
            stream.println("Hello World");

        } catch (IOException e) {
            Assertions.fail(e);
        }
    }
}
