package barokah.com;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

public class T2ConditionTest {

    @Test
    @EnabledOnOs(value = {OS.LINUX})
    public void testRunOnlyOnLinux(){
        System.out.println("Linux OS");
    }

    @Test
    @DisabledOnOs(value = {OS.LINUX})
    public void testRunOnNonLinux(){
        System.out.println("Non Linux OS");
    }

    @Test
    @EnabledIfSystemProperty(named = "java.vendor",matches = "Oracle Corporation")
    public void testEnableOnOracle(){
        System.out.println("Oracle ...");
    }

    @Test
    @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    public void testDisableOnOracle(){

    }

    @Test
    @EnabledIfSystemProperties({
            @EnabledIfSystemProperty(named = "java.vendor",matches = "Oracle Corporation")
    })
    public void testEnableOnOracle2(){

    }

    @Test
    @DisabledIfSystemProperties({
            @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    public void testDisableOnOracle2(){

    }

    @Test
    @EnabledIfEnvironmentVariable(named = "PROFILE",matches = "DEV")
    public void testForDevProfile(){

    }

    @Test
    @DisabledIfEnvironmentVariable(named = "PROFILE",matches = "DEV")
    public void testForNonDevProfile(){

    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = "PROFILE",matches = "DEV")
    })
    public void testForDevProfile2(){

    }

    @Test
    @DisabledIfEnvironmentVariables({
            @DisabledIfEnvironmentVariable(named = "PROFILE",matches = "DEV")
    })
    public void testForNonDevProfile2(){

    }

}
