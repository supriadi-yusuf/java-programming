package barokah.inc.belajar.jpa;

import barokah.inc.belajar.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P03TransactionTest {
    @Test
    public void testCreateTransaction(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        Assertions.assertNotNull(entityManagerFactory);

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Assertions.assertNotNull(entityManager);

        EntityTransaction entityTransaction = entityManager.getTransaction();
        Assertions.assertNotNull(entityTransaction);

        try {
            entityTransaction.begin();

            // manipulate DB

            entityTransaction.commit();
        }catch (Throwable throwable){
            entityTransaction.rollback();
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
