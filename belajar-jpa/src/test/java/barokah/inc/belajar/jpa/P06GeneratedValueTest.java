package barokah.inc.belajar.jpa;

import barokah.inc.belajar.jpa.entity.Category;
import barokah.inc.belajar.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P06GeneratedValueTest {
    @Test
    void testGeneratedValue() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Category category = new Category();
        category.setName("city");
        category.setDescription("city of people");

        entityManager.persist(category);
        Assertions.assertNotNull(category.getId());

        entityTransaction.commit();
        entityManager.close();
    }
}
