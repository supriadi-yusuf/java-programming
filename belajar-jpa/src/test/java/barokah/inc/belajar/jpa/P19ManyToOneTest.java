package barokah.inc.belajar.jpa;

import barokah.inc.belajar.jpa.entity.Brand;
import barokah.inc.belajar.jpa.entity.Credential;
import barokah.inc.belajar.jpa.entity.Product;
import barokah.inc.belajar.jpa.entity.User;
import barokah.inc.belajar.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class P19ManyToOneTest {
    @Test
    void testCreate(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Brand brand = new Brand();
        brand.setId("S01");
        brand.setName("Samsung");
        brand.setDescription("Brand is from Korea");

        entityManager.persist(brand);

        Product product1 = new Product();
        product1.setId("P01");
        product1.setName("Handphone");
        product1.setPrice(1_500_000d);
        product1.setDescription("Handphone merek Samsung tipe 1");
        product1.setBrand(brand);

        entityManager.persist(product1);

        Product product2 = new Product();
        product2.setId("P02");
        product2.setName("Tablet");
        product2.setPrice(8_000_000d);
        product2.setDescription("Tablet merek Samsung tipe 1");
        product2.setBrand(brand);

        entityManager.persist(product2);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void testFindBrand(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Brand brand = entityManager.find(Brand.class, "S01");
        Assertions.assertNotNull(brand);

        List<Product> products = brand.getProducts();
        Assertions.assertEquals(2,products.size());

        entityManager.close();
    }
}
