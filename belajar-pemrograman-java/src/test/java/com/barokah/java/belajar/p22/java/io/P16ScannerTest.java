package com.barokah.java.belajar.p22.java.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

// Scanner is to read data from input stream
public class P16ScannerTest {
    @Test
    void testScannerFromFile(){
        Path path = Path.of("print.txt");

        try (InputStream inputStream = Files.newInputStream(path);
             Scanner scanner = new Scanner(inputStream);){

            while (scanner.hasNext()){
                String data = scanner.nextLine();
                System.out.println(data);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            Assertions.fail(e);
        }
    }
}
