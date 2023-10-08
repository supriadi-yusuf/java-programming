package barokah.inc.belajar.jpa;

import barokah.inc.belajar.jpa.entity.Category;
import barokah.inc.belajar.jpa.entity.Member;
import barokah.inc.belajar.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P17ListenerOnEntityClassTest {
    @Test
    void testListenerOnEntityClass(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Member member = entityManager.find(Member.class, 1);
        Assertions.assertNotNull(member);
        Assertions.assertNotNull(member.getFullName());

        entityManager.close();
    }
}
