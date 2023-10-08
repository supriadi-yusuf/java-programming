package com.barokah.java.belajar.p20.lombok;

import com.barokah.java.belajar.p20.lombok.gettersetter.Customer;
import com.barokah.java.belajar.p20.lombok.gettersetter.Login;
import org.junit.jupiter.api.Test;

//@Getter is to create getter method for every field on class
//@Setter is to create setter method for evey field on class
public class P01GetterSetterTest {

    @Test
    void testGetterSetter() {
        Customer customer = new Customer();

        customer.setId("1");
        customer.setName("supriadi");

        System.out.println(customer.getId());
        System.out.println(customer.getName());
    }

    @Test
    void testAccessLevel(){
        Login user = new Login("user","pwd");

        user.setUserName("supriadi");
//        user.setPassword("pw123");

        System.out.println(user.getUserName());
        System.out.println(user.getPassword());

    }
}
