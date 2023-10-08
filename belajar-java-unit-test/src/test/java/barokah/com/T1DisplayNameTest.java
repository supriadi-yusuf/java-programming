package barokah.com;

import barokah.com.generator.SimpleDisplayNameGenerator;
import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;


@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
//@DisplayName("Test untuk calculator class")
class T1DisplayNameTest {

    private Calculator calculator = new Calculator();

    @BeforeAll // method must be static
    public static void beforeAll(){
        System.out.println("Before All");
    }

    @AfterAll // method must be static
    public static void afterAll(){
        System.out.println("After All");
    }

    @BeforeEach
    public void start(){
        System.out.println("Before each");
    }

    @AfterEach
    public void finish(){
        System.out.println("After each");
    }

    @Test
    public void testAborted(){
        String profile = System.getenv("PROFILE");
        System.out.println("profile = " + profile);
        if (!"DEV".equals(profile)){
            throw new TestAbortedException("test dibatalkan"); // stop this test
        }
    }

    @Test
    public void testAssumptions(){
        assumeTrue("DEV".equals(System.getenv("PROFILE")));
    }

    @Test
//    @DisplayName("Test scenario sukses untuk method add(Integer,Integer)")
    public void testAddSuccess(){
        Integer result = calculator.add(10, 10);
        assertEquals(20,result);
    }

    @Test
    public void testDivideSuccess(){
        Integer result = calculator.divide(100, 10);
        assertEquals(10, result);
    }

    @Test
    public void testDivideFail(){
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10,0));
    }

    @Test
    @Disabled // skipped
    public void testComingSoon(){

    }

}