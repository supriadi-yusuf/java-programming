package com.barokah.java.belajar.p20.lombok.builder;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder // Builder for this class will be created (in this case  PersonBuilder)
public class PersonWithSingular {
    private String id;
    private String name;
    private Integer age;
    @Singular // this annotation is for Collection type, we do not need to create collection for adding new data for this type
    private List<String> hobbies;
}
