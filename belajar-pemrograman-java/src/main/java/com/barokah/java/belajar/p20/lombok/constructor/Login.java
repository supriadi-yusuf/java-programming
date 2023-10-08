package com.barokah.java.belajar.p20.lombok.constructor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(staticName = "createEmpty") // create object with static method called createEmpty
@AllArgsConstructor(staticName = "create") // create object with static method called create
public class Login {
    private String userName;
    private String password;
}

