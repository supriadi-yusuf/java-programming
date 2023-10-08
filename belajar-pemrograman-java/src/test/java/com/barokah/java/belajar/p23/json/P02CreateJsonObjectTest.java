package com.barokah.java.belajar.p23.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

public class P02CreateJsonObjectTest {
    @Test
    void testCreateJson() throws JsonProcessingException {
        Map<String, Object> person = Map.<String, Object>of(
                "firstName","Budi",
                "lastName","Nugraha",
                "age",30,
                "married",true,
                "address",Map.<String,Object>of(
                        "street","Jalan 123",
                        "city","Jakarta",
                        "country","Indonesia"
                )
        );

        ObjectMapper mapper = new ObjectMapper();
        String data = mapper.writeValueAsString(person);

        System.out.println(data);
    }

    @Test
    void testCreateJsonFile()  {
        Map<String, Object> person = Map.<String, Object>of(
                "firstName","Budi",
                "lastName","Nugraha",
                "age",30,
                "married",true,
                "address",Map.<String,Object>of(
                        "street","Jalan 123",
                        "city","Jakarta",
                        "country","Indonesia"
                )
        );

        ObjectMapper mapper = new ObjectMapper();
        Path path = Path.of("json.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(path);){
           mapper.writeValue(writer,person);
        } catch (IOException e) {
            Assertions.fail(e);
        }
    }
}
