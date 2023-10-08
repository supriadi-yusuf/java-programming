package com.barokah.belajarwebservlet.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SayHelloRequest {
    private String firstName;
    private String lastName;
}
