package com.barokah.java.belajar.p23.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// https://github.com/FasterXML/jackson-databind
// https://github.com/FasterXML/jackson-databind/wiki

public class P01ObjectMapperTest {
    @Test
    void testCreateObjectMapper(){
        ObjectMapper objectMapper = new ObjectMapper();

        Assertions.assertNotNull(objectMapper);
    }
}
