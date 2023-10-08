package com.barokah.java.belajar.p20.lombok.tostring;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString(exclude = {"password"})
@Getter
@Setter
@AllArgsConstructor
public class LoginWithExclude {
    private String userName;
    private String password;
}

