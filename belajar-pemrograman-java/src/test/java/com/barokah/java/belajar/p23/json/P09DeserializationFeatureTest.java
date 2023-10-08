package com.barokah.java.belajar.p23.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P09DeserializationFeatureTest {
    @Test
    void testDeserialization() throws JsonProcessingException {
        Person person = null;
        String json = """
                {"id":"1","name":"eko","age":30,"hobbies":"reading"}
                """; // property eko does not exist in person. hobbies is array not single string.

        ObjectMapper mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false) // no field age in person
                .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        person = mapper.readValue(json, Person.class);

        Assertions.assertNotNull(person);
        Assertions.assertEquals("1", person.getId());
        Assertions.assertEquals(List.of("reading"), person.getHobbies());
    }
}
