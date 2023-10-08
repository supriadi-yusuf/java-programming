package barokah.inc.belajar.jpa;

import barokah.inc.belajar.jpa.entity.Image;
import barokah.inc.belajar.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class P10LargeObjectTest {
    @Test
    void testLargeObject() throws IOException {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Image image = new Image();
        image.setName("sample image");
        image.setDescription("image in jpg format");

        Path path = Path.of(getClass().getResource("/images/sample.jpg").getPath().replace("%20"," "));
        byte[] bytes = Files.readAllBytes(path);

        image.setImage(bytes);

        entityManager.persist(image);

        entityTransaction.commit();
        entityManager.close();
    }
}
