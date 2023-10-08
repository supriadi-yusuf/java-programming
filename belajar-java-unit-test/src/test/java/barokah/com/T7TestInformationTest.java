package barokah.com;

// we can supply test information to each method by passing object of type TestInfo into each method

import org.junit.jupiter.api.*;

@DisplayName("information test")
public class T7TestInformationTest {

    @Test
    @Tags({
            @Tag("one"),
            @Tag("two")
    })
    @DisplayName("this is test1")
    public void test1(TestInfo info){
        System.out.println(info.getDisplayName());
        System.out.println(info.getTags());
        System.out.println(info.getTestClass().orElse(null));
        System.out.println(info.getTestMethod().orElse(null));
    }
}
