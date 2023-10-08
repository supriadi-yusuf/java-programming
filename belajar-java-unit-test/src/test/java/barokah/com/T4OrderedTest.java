package barokah.com;

// create order of testing
// normally testing does not have order
// testing is independent for every method
// test object is created every time method is executed
// but we can make it executed in certain order

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//@TestMethodOrder(MethodOrderer.MethodName.class)
//@TestMethodOrder(MethodOrderer.Random.class)
public class T4OrderedTest {

    @Test
    @Order(1) // we have to put @Order(x) if we choose order annotation
    public void test3(){}

    @Test
    @Order(2)
    public void test2(){}

    @Test
    @Order(3)
    public void test1(){}
}
