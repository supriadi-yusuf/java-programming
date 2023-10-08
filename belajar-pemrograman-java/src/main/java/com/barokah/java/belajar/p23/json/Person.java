package com.barokah.java.belajar.p23.json;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class Person {
    private String id;
    private String name;
    private List<String> hobbies;
    private Address address;
}
