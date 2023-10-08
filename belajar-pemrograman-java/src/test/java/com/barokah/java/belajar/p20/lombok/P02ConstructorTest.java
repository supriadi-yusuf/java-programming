package com.barokah.java.belajar.p20.lombok;

import com.barokah.java.belajar.p20.lombok.constructor.Customer;
import static org.junit.jupiter.api.Assertions.*;

import com.barokah.java.belajar.p20.lombok.constructor.Login;
import org.junit.jupiter.api.Test;

//@NoArgsConstructor is to create constructor without parameter
//@RequiredArgsConstructor is to create constructor with several parameters marked as NonNull
//@AllArgsConstructor is to create constructor uses all field
public class P02ConstructorTest {
    @Test
    void testCustomer(){
        Customer customer = new Customer();

        assertNotNull(customer);
    }

    @Test
    void testCustomerWithArgs(){
        String id = "001";
        String name = "supriadi";

        Customer customer = new Customer(id, name);

        assertEquals(id,customer.getId());
        assertEquals(name,customer.getName());
    }

    @Test
    void testCustomerWithRequiredArgs(){
        Customer customer = new Customer("001");

        assertEquals("001",customer.getId());
        assertNull(customer.getName());
    }

    @Test
    void testPrivateConstructor(){
        Login emptyLogin = Login.createEmpty();

        assertNotNull(emptyLogin);
        assertNull(emptyLogin.getUserName());
        assertNull(emptyLogin.getPassword());
    }

    @Test
    void testPrivateConstructor2(){
        String userName = "supriadi";
        String password = "pw123";

        Login login = Login.create(userName,password);

        assertNotNull(login);
        assertEquals(userName,login.getUserName());
        assertEquals(password, login.getPassword());
    }

}
