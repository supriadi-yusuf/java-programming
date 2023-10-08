package com.barokah.java.belajar.p20.lombok.builder;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // Builder for this class will be created (in this case  PersonBuilder)
public class Person {
    private String id;
    private String name;
    private Integer age;
    private List<String> hobbies;
}
