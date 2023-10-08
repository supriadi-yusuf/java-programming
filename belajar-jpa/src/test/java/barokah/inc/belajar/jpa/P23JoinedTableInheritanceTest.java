package barokah.inc.belajar.jpa;

import barokah.inc.belajar.jpa.entity.*;
import barokah.inc.belajar.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P23JoinedTableInheritanceTest {
    @Test
    void testCreate(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        PaymentGopay gopay = new PaymentGopay();
        gopay.setId("P01");
        gopay.setGopayId("GP001");
        gopay.setAmount(1_500_000L);

        entityManager.persist(gopay);

        PaymentCreditCard creditCard = new PaymentCreditCard();
        creditCard.setId("P02");
        creditCard.setMaskedCard("AABBCC");
        creditCard.setBank("BCA");
        creditCard.setAmount(2_500_000L);

        entityManager.persist(creditCard);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void testFindChild(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        PaymentGopay gopay = entityManager.find(PaymentGopay.class, "P01");
        Assertions.assertNotNull(gopay);

        PaymentCreditCard creditCard = entityManager.find(PaymentCreditCard.class, "P02");
        Assertions.assertNotNull(creditCard);

        entityManager.close();
    }

    @Test
    void testFindParent() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Payment payment = entityManager.find(Payment.class, "P01"); // be carefull it will join all table ... very slow
        Assertions.assertNotNull(payment);

        entityManager.close();
    }
}
