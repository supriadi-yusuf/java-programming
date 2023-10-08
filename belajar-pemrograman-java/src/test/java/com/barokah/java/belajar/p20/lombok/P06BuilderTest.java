package com.barokah.java.belajar.p20.lombok;

import com.barokah.java.belajar.p20.lombok.builder.Person;
import com.barokah.java.belajar.p20.lombok.builder.PersonWithSingular;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//@Builder is to create builder object for class
public class P06BuilderTest {
    @Test
    void testBuilder(){
        List<String> hobbies = new ArrayList<>();
        hobbies.add("Game");
        hobbies.add("Read");
        hobbies.add("Traveling");

        Person person = Person.builder()
                .id("001")
                .name("supriadi")
                .age(30)
                .hobbies(hobbies)
                .build();

        System.out.println(person);
    }

    @Test
    void testBuilderWithSingular(){

        PersonWithSingular person = PersonWithSingular.builder()
                .id("001")
                .name("supriadi")
                .age(30)
                .hobby("Game") // we do not need to create list manually
                .hobby("Read") // we do not need to create list manually
                .hobby("Traveling") // we do not need to create list manually
                .build();

        System.out.println(person);

    }
}
