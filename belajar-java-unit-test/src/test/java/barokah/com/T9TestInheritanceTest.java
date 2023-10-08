package barokah.com;

// we can make child class from test class.
// child class will have all field, method, configuration of parent class

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

@DisplayName("test calculator")
public class T9TestInheritanceTest extends AbstractCalculatorTest {

    @Test
    public void testRandom(Random random){
        int a = random.nextInt();
        int b = random.nextInt();
        int result = a + b;

        Assertions.assertEquals(result,calculator.add(a,b));

    }
}
