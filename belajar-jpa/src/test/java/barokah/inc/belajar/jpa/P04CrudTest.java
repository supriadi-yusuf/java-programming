package barokah.inc.belajar.jpa;

import barokah.inc.belajar.jpa.entity.Customer;
import barokah.inc.belajar.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class P04CrudTest {
    private EntityManagerFactory entityManagerFactory;

    @BeforeEach
    void setUp() {
        entityManagerFactory = JpaUtil.getEntityManagerFactory();
    }

    @Test
    void testInsert() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        Customer customer = new Customer();
        customer.setId("1");
        customer.setName("supriadi");

        entityManager.persist(customer);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void testFind() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Customer customer = entityManager.find(Customer.class, "1");

        Assertions.assertNotNull(customer);
        Assertions.assertEquals("1", customer.getId());
        Assertions.assertEquals("supriadi", customer.getName());

        entityManager.close();
    }

    @Test
    void testUpdate(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = entityManager.find(Customer.class, "1");

        Assertions.assertNotNull(customer);
        Assertions.assertEquals("1", customer.getId());
        Assertions.assertEquals("supriadi", customer.getName());

        customer.setName("Yulianto");
        entityManager.merge(customer);//update

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void testDelete(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        entityTransaction.begin();

        Customer customer = entityManager.find(Customer.class, "1");

        Assertions.assertNotNull(customer);
        Assertions.assertEquals("1", customer.getId());

        entityManager.remove(customer);

        entityTransaction.commit();
        entityManager.close();
    }
}
