package barokah.inc.belajar.jpa;

import barokah.inc.belajar.jpa.entity.Customer;
import barokah.inc.belajar.jpa.entity.CustomerType;
import barokah.inc.belajar.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

public class P11TransientTest {
    @Test
    void testTransient(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Customer customer = new Customer();
        customer.setId("4");
        customer.setName("jajang");
        customer.setType(CustomerType.PREMIUM);
        customer.setAge((byte)23);
        customer.setMarried(false);
        customer.setPrimaryEmail("jajang@yaho.com");
        customer.setFullName("jajang wibowo");


        entityManager.persist(customer);

        entityTransaction.commit();
        entityManager.close();
    }
}
