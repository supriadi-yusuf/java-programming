package barokah.com;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

// We can supply data for testing with :
// @ValueSource for Number, Char, Boolean, String
// @EnumSource for enum source
// @MethodSource (static method)
// @CsvSource
// @CsvFileSource
// @ArgumentSource
public class T11TestWithParameterTest {

    private Calculator calculator = new Calculator();

    private static List<Integer> getList(){
        return List.of(4,2,6,7,8,9,1,93,15,23);
    }

    @DisplayName("test calculator")
    @ParameterizedTest(name = "{displayName} dengan parameter {0}")
    @ValueSource(ints = {5,2,3,5,7,1,9,7,5,72})
    void testCalculatorWithParameter(int value){
        int expected = value + value;

        Integer result = calculator.add(value, value);
        Assertions.assertEquals(expected,result);
    }

    @DisplayName("test calculator method")
    @ParameterizedTest(name = "{displayName} dengan parameter {0}")
    @MethodSource({"getList"})
    void testCalculatorWithMethodParameter(int value){
        int expected = value + value;

        Integer result = calculator.add(value, value);
        Assertions.assertEquals(expected,result);
    }
}
