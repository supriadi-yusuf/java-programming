package barokah.inc.belajar.jpa;

import barokah.inc.belajar.jpa.util.JpaUtil;
import jakarta.persistence.EntityManagerFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P01EntityManagerFactoryTest {
    @Test
    void testCreateEntityManagerFactory(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        Assertions.assertNotNull(entityManagerFactory);

        entityManagerFactory.close();
    }

}
