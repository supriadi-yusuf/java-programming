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
public class T16VerifyMethodTest {

    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp(){
        personService = new PersonService(personRepository);
    }

    @Test
    void testRegisterSuccess() {
        String name = "supriadi";

        Person result = personService.register(name);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(name, result.getName());
        Assertions.assertNotNull(result.getId());

        Mockito.verify(personRepository, Mockito.times(1)).insert(new Person(result.getId(), name));

    }


}
