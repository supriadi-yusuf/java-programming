package com.barokah.java.belajar.p22.java.io;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P11WriterTest {
    @Test
    void testWriteOneChar(){
        char[] chars = "Hello World\n".toCharArray();

        Path path = Path.of("write-one-char.txt");
        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(path);) {
            for (int i=0; i<20; i++){
                for (int j=0; j<chars.length;j++){
                    bufferedWriter.write(chars[j]);
                }

                bufferedWriter.flush();
            }
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void testWriteSeveralChar(){
        char[] chars = "Hello World\n".toCharArray();

        Path path = Path.of("write-several-chars.txt");
        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(path);) {
            for (int i=0; i<20; i++){
                bufferedWriter.write(chars);
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }

    @Test
    void testWriteString(){
        String data = "Hello World\n";

        Path path = Path.of("write-string.txt");
        try(BufferedWriter bufferedWriter = Files.newBufferedWriter(path);) {
            for (int i=0; i<20; i++){
                bufferedWriter.write(data);
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }
}
