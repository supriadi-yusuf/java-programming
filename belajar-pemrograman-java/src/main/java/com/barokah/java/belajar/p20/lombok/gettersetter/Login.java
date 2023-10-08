package com.barokah.java.belajar.p20.lombok.gettersetter;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
public class Login {
    @Setter(value = AccessLevel.PUBLIC)
    private String userName;

    @Setter(value = AccessLevel.PROTECTED)
    private String password;

    public Login() {
    }

    public Login(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
