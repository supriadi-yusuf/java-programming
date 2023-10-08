package com.barokah.java.belajar.p20.lombok;

// @With is annotation to generate method withXxx (Xxx is field name).
// this method is to generate new object. Xxx becomes method parameter.

import com.barokah.java.belajar.p20.lombok.with.RegisterWith;
import com.barokah.java.belajar.p20.lombok.with.RegisterWithAll;
import com.barokah.java.belajar.p20.lombok.with.RegisterWiths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P09WithTest {
    @Test
    void testWith(){
        RegisterWith register = new RegisterWith("user","password");

        RegisterWith withPassword = register.withPassword("new password");
        Assertions.assertEquals(register.getUserName(),withPassword.getUserName());
    }

    @Test
    void testWiths(){
        RegisterWiths register = new RegisterWiths("user","password");

        RegisterWiths withUserName = register.withUserName("user");
        Assertions.assertEquals(register.getPassword(),withUserName.getPassword());

        RegisterWiths withPassword = register.withPassword("pass 123");
        Assertions.assertEquals(register.getUserName(),withPassword.getUserName());
    }

    @Test
    void testWithAll(){
        RegisterWithAll register = new RegisterWithAll("user", "password");
        RegisterWithAll withUserName = register.withUserName("user");
        Assertions.assertEquals(register.getPassword(),withUserName.getPassword());

        RegisterWithAll withPassword = register.withPassword("pass 123");
        Assertions.assertEquals(register.getUserName(),withPassword.getUserName());
    }
}
