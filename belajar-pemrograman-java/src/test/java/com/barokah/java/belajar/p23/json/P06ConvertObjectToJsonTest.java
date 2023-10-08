package com.barokah.java.belajar.p23.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P06ConvertObjectToJsonTest {
    @Test
    void testConvertObjectToJson() throws JsonProcessingException {
        Person person = new Person();
        person.setId("1");
        person.setName("Adi");
        person.setHobbies(List.<String>of("Coding","Reading"));

        Address address = new Address();
        address.setStreet("Jalan 1234");
        address.setCity("Jakarta");
        address.setCountry("Indonesia");

        person.setAddress(address);

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(person);

        System.out.println(json);
    }
}
