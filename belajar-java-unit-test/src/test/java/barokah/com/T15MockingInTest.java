package barokah.com;

import barokah.com.data.Person;
import barokah.com.repository.PersonRepository;
import barokah.com.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class T15MockingInTest {

    //    private PersonRepository personRepository = Mockito.mock(PersonRepository.class);
//    replace with
    @Mock
    private PersonRepository personRepository;

    //    private PersonService personService = new PersonService(personRepository);
//    replace with :
    private PersonService personService;

    @BeforeEach
    void setUp(){
        personService = new PersonService(personRepository);
    }


    @Test
    void testNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            personService.get(Mockito.anyString());
        });
    }

    @Test
    void testGetPersonSuccess() {

        Person person = new Person("1", "supriadi");

        Mockito.when(personRepository.selectById("1"))
                .thenReturn(person);

        Person result = personService.get("1");

        Assertions.assertNotNull(result);
        Assertions.assertEquals(person, result);
    }

}
