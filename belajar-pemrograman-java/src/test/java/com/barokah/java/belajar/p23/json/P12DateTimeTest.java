package com.barokah.java.belajar.p23.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class P12DateTimeTest {
    @Test
    void testJsonDateFormatSerialization() throws JsonProcessingException {
        PersonDate person = new PersonDate();
        person.setId("1");
        person.setName("Supriadi");

        Date currdate = new Date();
        person.setCreateAt(currdate);
        person.setUpdateAt(currdate);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:SS");

        ObjectMapper mapper = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)// by default date will be shown as timestamp, set it off
                .setDateFormat(dateFormat);// set date format with new format

        String json = mapper.writeValueAsString(person);

        System.out.println(json);
    }

    @Test
    void testDateDeserialization() throws JsonProcessingException {
        String json = """
                {"id":"1","name":"Supriadi","createAt":"22-09-2023 20:17:411","updateAt":"22-09-2023 20:17:411"}
                """;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:SS");

        ObjectMapper mapper = new ObjectMapper()
                .setDateFormat(dateFormat);

        PersonDate person = mapper.readValue(json, PersonDate.class);

        System.out.println(person.getCreateAt());
        System.out.println(person);
    }
}
