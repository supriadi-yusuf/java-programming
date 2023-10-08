package com.barokah.java.belajar.p20.lombok.equalsandhashcode;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"name"})
public class EmployeeWihExclude {
    private String id;
    private String name;
}
