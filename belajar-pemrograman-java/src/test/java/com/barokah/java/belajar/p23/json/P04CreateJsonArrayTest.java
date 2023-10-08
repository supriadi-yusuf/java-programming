package com.barokah.java.belajar.p23.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P04CreateJsonArrayTest {
    @Test
    void testCreateJsonArray() throws JsonProcessingException {
        List<String> hobbies = List.<String>of("Coding","Traveling","Reading");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(hobbies);

        System.out.println(json);
    }
}
