package com.barokah.java.belajar.p22.java.io;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

@Slf4j
public class P13ObjectStreamTest {
    @Test
    void testSaveObject() {
        Person person = new Person();
        person.setId("1");
        person.setName("supriadi");

        Path path = Path.of("supri.person");

        try (OutputStream outputStream = Files.newOutputStream(path);) {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(person);// object is stored into binary file. we can not open binary file with text editor
            objectOutputStream.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
            Assertions.fail(e);
        }
    }

    @Test
    public void testGetObject() {
        Path path = Path.of("supri.person");

        try (InputStream inputStream = Files.newInputStream(path);) {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            Person person = (Person) objectInputStream.readObject();

            Assertions.assertEquals("1", person.getId());
            Assertions.assertEquals("supriadi", person.getName());
        } catch (IOException | ClassNotFoundException e) {
            Assertions.fail(e);
        }
    }
}
