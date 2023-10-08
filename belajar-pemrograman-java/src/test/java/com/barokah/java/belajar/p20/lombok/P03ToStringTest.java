package com.barokah.java.belajar.p20.lombok;

import com.barokah.java.belajar.p20.lombok.tostring.LoginWithExclude;
import com.barokah.java.belajar.p20.lombok.tostring.Login;
import org.junit.jupiter.api.Test;
//@ToString is to create toString() method
public class P03ToStringTest {
    @Test
    void testToString(){
        Login login = new Login("supriadi","pwd12345");
        System.out.println(login.toString());
    }

    @Test
    void testToStringWithExclude() {
        LoginWithExclude loginWithExclude = new LoginWithExclude("supriadi", "pwd12345");
        System.out.println(loginWithExclude.toString());
    }

}
