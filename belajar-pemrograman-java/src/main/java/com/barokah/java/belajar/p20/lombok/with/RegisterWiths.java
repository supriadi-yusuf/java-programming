package com.barokah.java.belajar.p20.lombok.with;

import lombok.Value;
import lombok.With;

@Value
public class RegisterWiths {
    @With
    String userName;
    @With
    String password;
}
