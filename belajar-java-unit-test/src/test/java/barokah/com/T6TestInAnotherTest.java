package barokah.com;

import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.Queue;

// we can make several inner class in test class then request JUnit to execute every inner class with @Nested

@DisplayName("A Queue")
public class T6TestInAnotherTest {

    private Queue<String> queue;

    @Nested // mark this inner class in order to be executed by JUnit as test class
    @DisplayName("when new")
    public class WhenNew {

        @BeforeEach
        void setUp(){
            queue = new LinkedList<>();
        }

        @Test
        @DisplayName("when offer once, size must be 1")
        public void testAddOne(){
            queue.offer("a");
            Assertions.assertEquals(1, queue.size());
        }

        @Test
        @DisplayName("when offer twice, size must be 2")
        public void testAddMore(){
            queue.offer("a");
            queue.offer("b");
            Assertions.assertEquals(2, queue.size());
        }

    }
}
