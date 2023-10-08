package barokah.inc.belajar.jpa;

import barokah.inc.belajar.jpa.entity.Customer;
import barokah.inc.belajar.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

public class P05ColumnTest {
    @Test
    void testColumn(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        Customer customer = new Customer();
        customer.setId("1");
        customer.setName("supriadi");
        customer.setPrimaryEmail("supriadi@gmail.com");

        entityManager.persist(customer);

        entityTransaction.commit();

        entityManager.close();
    }
}
