package com.barokah.java.belajar.p23.json;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class PersonAnnotation {
    private String id;
    private String name;
    @JsonProperty("full_name")
    private String fullName;
    @JsonIgnore
    private String password;
    private List<String> hobbies;
    private Address address;
    private Date createAt;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateAt;
}
