package barokah.com;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

// test life cycle is per method (Lifcycle.PER_METHOD) by default. it means that test instance is created individually for every method.
// but we can make it per class (Lifecycle.PER_CLASS) so test instance is only created for each class not each method

//@TestInstance(value = TestInstance.Lifecycle.PER_METHOD)
@TestInstance(value = TestInstance.Lifecycle.PER_CLASS)
public class T5LifeCycleTest {
    private int totalHit = 0;

    @Test
    public void test1(){
        totalHit++;
        System.out.println(totalHit);
    }

    @Test
    public void test2(){
        totalHit++;
        System.out.println(totalHit);
    }

    @Test
    public void test3(){
        totalHit++;
        System.out.println(totalHit);
    }
}
