package com.barokah.java.belajar.p23.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P05ReadJsonArrayTest {
    @Test
    void testReadJsonArray() throws JsonProcessingException {
        String json = """
                ["Coding","Traveling","Reading"]
                """;

        ObjectMapper mapper = new ObjectMapper();
        List<String> hobbies = mapper.readValue(json, new TypeReference<List<String>>() {
        });

        Assertions.assertEquals(List.<String>of("Coding","Traveling","Reading"), hobbies);
    }
}
