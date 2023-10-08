package com.barokah.java.belajar.p23.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://github.com/FasterXML/jackson-databind/wiki/Mapper-Features
public class P08MapperFeatureTest {
    @Test
    void testAcceptCaseInsensitive(){
        ObjectMapper mapper = new ObjectMapper()
                .configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES,true);

        String json = """
                {"ID":"1","Name":"Adi"}
                """;

        Person person = null;

        try {
            person = mapper.readValue(json, Person.class);
        } catch (JsonProcessingException e) {
            Assertions.fail(e);
        }

        Assertions.assertNotNull(person);
        Assertions.assertEquals("1",person.getId());
        Assertions.assertEquals("Adi",person.getName());

    }
}
