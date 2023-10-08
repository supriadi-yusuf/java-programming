package com.barokah.java.belajar.p20.lombok;

import com.barokah.java.belajar.p20.lombok.nonnull.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//@NonNull is to make not null parameter
//@NonNull is to make field becomes not null on setter method
//@NonNull is also to mark field should be put on required args constructor and check if this field is not null on constructor
public class P07NonNullTest {
    @Test
    void testRequiredArgsConstructor(){
        Assertions.assertThrows(NullPointerException.class, ()->{
            new Member(null);
        });
    }

    @Test
    void testAllArgsConstructor(){
        Assertions.assertThrows(NullPointerException.class,()->{
           new Member(null,"supri");
        });
    }

    @Test
    void testSetter(){
        Member member = new Member();

        Assertions.assertThrows(NullPointerException.class,()->{
           member.setId(null);
        });
    }

    @Test
    void testParameter(){
        Member member = new Member();

        Assertions.assertThrows(NullPointerException.class, ()->{
           member.sayHello(null);
        });
    }
}
