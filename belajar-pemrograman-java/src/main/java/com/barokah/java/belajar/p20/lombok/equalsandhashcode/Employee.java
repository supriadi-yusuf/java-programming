package com.barokah.java.belajar.p20.lombok.equalsandhashcode;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Employee {
    private String id;
    private String name;
}
