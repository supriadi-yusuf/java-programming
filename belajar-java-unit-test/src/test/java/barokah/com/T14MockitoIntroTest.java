package barokah.com;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

public class T14MockitoIntroTest {
    @Test
    public void testIntro(){
        List<String> list = Mockito.mock(List.class);

        // mock object has different behavior with real object
        // we try to get value on index 0
        // if this is real list, this will return error
        // but because of mock object, this will return null because we do not set behavior for this mock object
        String value = list.get(0);

        System.out.println(value);

        // now we set behaviour
        Mockito.when(list.get(0)).thenReturn("supriadi");


        // this should return "supriadi"
        value = list.get(0);

        System.out.println(value);

        // we can verify how times method list.get(0) is called. we call it twice
//        Mockito.verify(list,Mockito.times(1)).get(0); // this is error because list.get(0) is called twice not once
        Mockito.verify(list,Mockito.times(2)).get(0); // this is correct because list.get(0) is called twice

    }
}
