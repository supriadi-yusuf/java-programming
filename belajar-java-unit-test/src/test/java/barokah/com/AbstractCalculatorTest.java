package barokah.com;

import barokah.com.resolver.RandomParameterResolver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;

@Extensions({
        @ExtendWith(value = RandomParameterResolver.class)
})
public abstract class AbstractCalculatorTest {

    protected Calculator calculator = new Calculator();

    @BeforeEach
    public void setUp(){
        System.out.println("before each");
    }
}
