package com.barokah.java.belajar.p23.json;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class PersonDate {
    private String id;
    private String name;
    private List<String> hobbies;
    private Address address;
    private Date createAt;
    private Date updateAt;
}
