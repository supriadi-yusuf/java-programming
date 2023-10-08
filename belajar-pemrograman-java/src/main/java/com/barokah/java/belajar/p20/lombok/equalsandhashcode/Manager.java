package com.barokah.java.belajar.p20.lombok.equalsandhashcode;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Manager extends Employee{
    private int totalEmployee;
}
