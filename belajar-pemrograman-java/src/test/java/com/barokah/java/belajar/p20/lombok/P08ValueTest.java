package com.barokah.java.belajar.p20.lombok;

import com.barokah.java.belajar.p20.lombok.value.Register;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//@Value is to make immutable object and final class, all field will become final
public class P08ValueTest {
    @Test
    void testValueAnnotation(){
        String userName = "user";
        String password = "pass";

        Register register = new Register(userName,password);

        Assertions.assertEquals(userName,register.getUserName());
        Assertions.assertEquals(password,register.getPassword());
    }
}
