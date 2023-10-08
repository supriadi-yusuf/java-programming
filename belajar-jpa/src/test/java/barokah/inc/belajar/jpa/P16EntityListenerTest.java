package barokah.inc.belajar.jpa;

import barokah.inc.belajar.jpa.entity.Category;
import barokah.inc.belajar.jpa.entity.Member;
import barokah.inc.belajar.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P16EntityListenerTest {
    @Test
    void testEntityListener(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Category category = new Category();
        category.setName("sport");

        entityManager.persist(category);

        Assertions.assertNotNull(category.getUpdatedAt());

        entityTransaction.commit();
        entityManager.close();
    }
}
