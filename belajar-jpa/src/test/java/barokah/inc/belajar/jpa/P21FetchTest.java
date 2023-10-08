package barokah.inc.belajar.jpa;

import barokah.inc.belajar.jpa.entity.Product;
import barokah.inc.belajar.jpa.entity.User;
import barokah.inc.belajar.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class P21FetchTest {
    @Test
    void testLazyFetch(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Product product = entityManager.find(Product.class, "P01");
        Assertions.assertNotNull(product);

        entityManager.close();
    }
}
