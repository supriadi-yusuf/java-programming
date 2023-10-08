package com.barokah.java.belajar.p23.json;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Address {
    private String street;
    private String city;
    private String country;
}
