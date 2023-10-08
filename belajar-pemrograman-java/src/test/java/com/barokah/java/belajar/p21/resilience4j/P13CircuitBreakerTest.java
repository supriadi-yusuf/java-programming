package com.barokah.java.belajar.p21.resilience4j;

import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

// Circuit breaker state : CLOSE ( receive request), OPEN ( reject request), HALF_OPEN ( receive several request)
// when created it's status is CLOSE. then if failure rate is more than threshold state goes to OPEN. after certain duration
// state goes to HALF OPEN. from HALF OPEN if failure rate is less than threshold then state goes to CLOSE other wise it goes back to OPEN.

@Slf4j
public class P13CircuitBreakerTest {

    public void callMe(){
        log.info("Call Me");
        throw new IllegalArgumentException("Ups");
    }

    @Test
    void testCircuitBreaker(){

        CircuitBreaker breaker = CircuitBreaker.ofDefaults("test");

        for (int i=1; i<=200; i++){
            try {
                Runnable runnable = CircuitBreaker.decorateRunnable(breaker, () -> callMe());
                runnable.run();
            }catch (Exception e){
                log.error("Error {}",e.getMessage());
            }
        }
    }
}
