package com.barokah.java.belajar.p20.lombok.equalsandhashcode;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true) // by default parent object is not called. if we want to make parent object is called set (callSuper=true)
public class ManagerWihCallSuper extends Employee{
    private int totalEmployee;
}
