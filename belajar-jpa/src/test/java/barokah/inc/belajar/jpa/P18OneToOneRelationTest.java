package barokah.inc.belajar.jpa;

import barokah.inc.belajar.jpa.entity.Category;
import barokah.inc.belajar.jpa.entity.Credential;
import barokah.inc.belajar.jpa.entity.User;
import barokah.inc.belajar.jpa.entity.Wallet;
import barokah.inc.belajar.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P18OneToOneRelationTest {
    @Test
    void testCreateUserAndCredential(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User user = new User();
        user.setId("1");
        user.setName("uda");

        entityManager.persist(user);

        Credential credential = new Credential();
        credential.setId(user.getId());
        credential.setEmail("yaya@yahoo.com");
        credential.setPassword("pass1234");

        entityManager.persist(credential);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void testFindUserAndCredential(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        User user = entityManager.find(User.class, "1");
        Assertions.assertNotNull(user);

        Credential credential = user.getCredential();
        Assertions.assertNotNull(credential);

        Assertions.assertEquals(user.getId(),credential.getId());

        entityManager.close();
    }

   /* @Test
    void testDeleteUserAndCredential(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User user = entityManager.find(User.class, "1");
        entityManager.remove(user);

        Credential credential = entityManager.find(Credential.class, "1");
        entityManager.remove(credential);

        entityTransaction.commit();
        entityManager.close();
    }*/

    @Test
    void testCreateWallet(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User user = entityManager.find(User.class, "1");
        Assertions.assertNotNull(user);

        Wallet wallet = new Wallet();
        wallet.setUser(user);
        wallet.setBalance(1_000_000d);

        entityManager.persist(wallet);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void testFindWallet(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Wallet wallet = entityManager.find(Wallet.class, "3");
        Assertions.assertNotNull(wallet);

        User user = wallet.getUser();
        Assertions.assertNotNull(user);

        entityManager.close();
    }

    @Test
    void testDeleteWallet(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Wallet wallet = entityManager.find(Wallet.class, 1);
        Assertions.assertNotNull(wallet);

        entityManager.remove(wallet);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void testDeleteUser(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User user = entityManager.find(User.class, "1");
        Assertions.assertNotNull(user);

        entityManager.remove(user);

        entityTransaction.commit();
        entityManager.close();
    }

}
