package com.barokah.java.belajar.p22.java.io;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class Person implements Serializable {
    public static final long serialVersionUID = 1L;

    private String id;
    private String name;
}
