package barokah.com;

// testing can be run in parallel
// step :
// 1. create folder resource under test folder
// 2. create file junit-platform.properties in the resource folder
// 3. set value : junit.jupiter.execution.parallel.enabled = true
// 4. put @Execution(value = ExecutionMode.CONCURRENT) on test class

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

@Execution(value = ExecutionMode.CONCURRENT)
public class T13TestPararelTest {

    @Test
    public void slow1() throws InterruptedException {
        Thread.sleep(4_000);
    }

    @Test
    public void slow2() throws InterruptedException {
        Thread.sleep(4_000);
    }

    @Test
    public void slow3() throws InterruptedException {
        Thread.sleep(4_000);
    }
}
