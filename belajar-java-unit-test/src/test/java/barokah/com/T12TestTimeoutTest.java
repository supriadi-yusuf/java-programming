package barokah.com;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

// we can set time out for certain testing

public class T12TestTimeoutTest {

    @Test
    @Timeout(value = 3, unit = TimeUnit.SECONDS)
    public void testSlow() throws InterruptedException {
        Thread.sleep(10_000);
    }
}
