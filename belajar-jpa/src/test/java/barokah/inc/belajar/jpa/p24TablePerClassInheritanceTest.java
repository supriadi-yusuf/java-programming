package barokah.inc.belajar.jpa;

import barokah.inc.belajar.jpa.entity.*;
import barokah.inc.belajar.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class p24TablePerClassInheritanceTest {
    @Test
    void testCreate(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Transaction transaction = new Transaction();
        transaction.setId("TR001");
        transaction.setBalance(1_000_000L);
        transaction.setCreatedAt(LocalDateTime.now());

        entityManager.persist(transaction);

        TransactionCredit credit = new TransactionCredit();
        credit.setId("TR002");
        credit.setBalance(500_000L);
        credit.setCreditAmount(1_000_000L);
        credit.setCreatedAt(LocalDateTime.now());

        entityManager.persist(credit);

        TransactionDebit debit = new TransactionDebit();
        debit.setId("TR003");
        debit.setBalance(2_000_000L);
        debit.setDebitAmount(1_000_000L);
        debit.setCreatedAt(LocalDateTime.now());

        entityManager.persist(debit);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void testFindChild(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TransactionCredit credit = entityManager.find(TransactionCredit.class, "TR002");
        Assertions.assertNotNull(credit);

        TransactionDebit debit = entityManager.find(TransactionDebit.class, "TR003");
        Assertions.assertNotNull(debit);

        entityManager.close();
    }

    @Test
    void testFindParent() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Transaction transaction = entityManager.find(Transaction.class, "TR002"); // it is very slow
        Assertions.assertNotNull(transaction);

        entityManager.close();
    }
}
