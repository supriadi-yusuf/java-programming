package barokah.com;

import barokah.com.resolver.RandomParameterResolver;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;

import java.util.Random;

//@ExtendWith(RandomParameterResolver.class)
@Extensions({
        @ExtendWith(RandomParameterResolver.class)
})
public class T8DependencyInjectionTest {
    private Calculator calculator = new Calculator();

    @Test
    public void testAdd(Random random){
        int a = random.nextInt();
        int b = random.nextInt();

        Integer result = calculator.add(a, b);
        int expected = a + b;

        Assertions.assertEquals(expected,result);
    }
}
