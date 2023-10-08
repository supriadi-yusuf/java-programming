package com.barokah.java.belajar.p23.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P07ConvertJsonToObjectTest {
    @Test
    void testConvertJsonToObject() throws JsonProcessingException {
        String json = """
                {"id":"1","name":"Adi","hobbies":["Coding","Reading"],"address":{"street":"Jalan 1234","city":"Jakarta","country":"Indonesia"}}
                """;

        ObjectMapper mapper = new ObjectMapper();
        Person person = mapper.readValue(json, Person.class);

        Assertions.assertEquals("1",person.getId());
        Assertions.assertEquals("Adi",person.getName());
        Assertions.assertEquals(List.<String>of("Coding","Reading"),person.getHobbies());
        Assertions.assertEquals("Jalan 1234",person.getAddress().getStreet());
        Assertions.assertEquals("Jakarta",person.getAddress().getCity());
        Assertions.assertEquals("Indonesia",person.getAddress().getCountry());
    }
}
