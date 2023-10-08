package com.barokah.java.belajar.p20.lombok;

import com.barokah.java.belajar.p20.lombok.synchronizedlombok.Counter;
import org.junit.jupiter.api.Test;

public class P13SynchronizedTest {
    @Test
    void testSynchronized() throws InterruptedException {
        Counter counter = new Counter();

        for (int i=1; i<=100; i++){
            new Thread(()->{
                for (int j=1; j<=100; j++){
                    counter.increment();
                }
            }).start();
        }

        Thread.sleep(3000);

        System.out.println(counter.getCounter());
    }
}
