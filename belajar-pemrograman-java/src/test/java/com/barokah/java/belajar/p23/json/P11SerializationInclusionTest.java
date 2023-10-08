package com.barokah.java.belajar.p23.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class P11SerializationInclusionTest {
    @Test
    void testSerializationInclusion() throws JsonProcessingException {
        Person person = new Person();
        person.setId("1");
        person.setName("Adi");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(person);
        System.out.println(json); // non null value is included

        ObjectMapper mapper2 = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL);// include non null only, null value is excluded
        String json2 = mapper2.writeValueAsString(person);

        System.out.println(json2); // non null value is excluded
    }
}
