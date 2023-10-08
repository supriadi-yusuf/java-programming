package barokah.com;

// we can make child class from test class.
// child class will have all field, method, configuration of parent class

import org.junit.jupiter.api.*;

import java.util.Random;

@DisplayName("test calculator")
public class T10TestRepetitionTest extends AbstractCalculatorTest {

    @DisplayName("test calculator add")
    @RepeatedTest(
            value = 10,
            name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
    )
    public void testRandomRepeat(Random random){
        int a = random.nextInt();
        int b = random.nextInt();
        int result = a + b;

        Assertions.assertEquals(result,calculator.add(a,b));
    }

    @DisplayName("test calculator add info")
    @RepeatedTest(
            value = 10,
            name = "{displayName} ke {currentRepetition} dari {totalRepetitions}"
//            name = "{displayName}"
    )
    public void testRandomRepeatInfo(Random random, RepetitionInfo info){

        System.out.println(info.getCurrentRepetition() + " dari " + info.getTotalRepetitions());

        int a = random.nextInt();
        int b = random.nextInt();
        int result = a + b;

        Assertions.assertEquals(result,calculator.add(a,b));
    }
}
