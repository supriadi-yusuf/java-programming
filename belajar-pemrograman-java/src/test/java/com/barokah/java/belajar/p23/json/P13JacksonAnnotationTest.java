package com.barokah.java.belajar.p23.json;

// https://github.com/FasterXML/jackson-annotations
// https://github.com/FasterXML/jackson-annotations/wiki/Jackson-Annotations

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

// @JsonIgnore
// @JsonFormat
// @JsonProperty
public class P13JacksonAnnotationTest {
    @Test
    void testAnnotations() throws JsonProcessingException {
        PersonAnnotation person = new PersonAnnotation();

        person.setId("1");
        person.setName("Adi");
        person.setFullName("Adi Hermawan");
        person.setPassword("hello 1234");

        Date currDate = new Date();
        person.setCreateAt(currDate);
        person.setUpdateAt(currDate);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
        ObjectMapper mapper = new ObjectMapper()
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .configure(SerializationFeature.INDENT_OUTPUT,true)
                .setDateFormat(dateFormat);

        String json = mapper.writeValueAsString(person);

        System.out.println(json);

    }
}
