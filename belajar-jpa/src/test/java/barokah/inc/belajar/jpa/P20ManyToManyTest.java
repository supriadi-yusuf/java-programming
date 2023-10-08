package barokah.inc.belajar.jpa;

import barokah.inc.belajar.jpa.entity.Brand;
import barokah.inc.belajar.jpa.entity.Product;
import barokah.inc.belajar.jpa.entity.User;
import barokah.inc.belajar.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class P20ManyToManyTest {
    @Test
    void testCreateManyToMany(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        User user = entityManager.find(User.class, "3");
        Assertions.assertNotNull(user);

        Product product1 = entityManager.find(Product.class, "P01");
        Assertions.assertNotNull(product1);

        Product product2 = entityManager.find(Product.class, "P02");
        Assertions.assertNotNull(product2);

        Product product3 = entityManager.find(Product.class, "P03");
        Assertions.assertNotNull(product3);

        Set<Product> likes = user.getLikes();
        if (likes.isEmpty()){
            user.setLikes(new HashSet<>());
        }

        user.getLikes().add(product1);
        user.getLikes().add(product2);
        user.getLikes().add(product3);

        entityManager.merge(user);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void testFindUserLikesProducts(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        User user = entityManager.find(User.class, "1");
        Assertions.assertNotNull(user);

        Set<Product> likes = user.getLikes();
        Assertions.assertNotNull(likes);
        Assertions.assertEquals(3,likes.size());

        entityManager.close();
    }
}
