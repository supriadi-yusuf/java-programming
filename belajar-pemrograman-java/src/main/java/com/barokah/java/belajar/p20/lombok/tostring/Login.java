package com.barokah.java.belajar.p20.lombok.tostring;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
public class Login {
    private String userName;
    private String password;
}

