package com.barokah.java.belajar.p22.java.io;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class P05CloseableTest {
    @Test
    void testCloseable(){
        Path path = Path.of("pom.xml");
        Path path2 = Path.of("src/main/resources/application.properties");


        try(
                InputStream inputStream = Files.newInputStream(path);
                InputStream inputStream2 = Files.newInputStream(path2);
        ) {
            System.out.println("Process files ...");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
