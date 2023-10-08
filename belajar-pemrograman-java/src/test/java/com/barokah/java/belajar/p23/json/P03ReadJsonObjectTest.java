package com.barokah.java.belajar.p23.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class P03ReadJsonObjectTest {
    @Test
    void testReadJson() throws JsonProcessingException {
        String json = """
                {
                  "address": {
                     "city":"Jakarta",
                     "country":"Indonesia",
                     "street":"Jalan 123"
                  },
                  "firstName":"Budi",
                  "lastName":"Nugraha",
                  "married":true,
                  "age":30}
                """;

        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> person =(Map<String,Object>) mapper.readValue(json, Map.class);

        Assertions.assertEquals("Budi",person.get("firstName"));

        person = mapper.readValue(json, new TypeReference<Map<String,Object>>() {
        });
        Assertions.assertEquals("Budi",person.get("firstName"));

//        JavaType javaType = mapper.constructType(Map.class);
        JavaType javaType = TypeFactory.defaultInstance().constructType(Map.class);

        person = (Map<String,Object>) mapper.readValue(json, javaType);

        Assertions.assertEquals("Budi",person.get("firstName"));


    }
}
