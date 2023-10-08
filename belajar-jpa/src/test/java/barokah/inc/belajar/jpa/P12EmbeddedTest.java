package barokah.inc.belajar.jpa;

import barokah.inc.belajar.jpa.entity.Customer;
import barokah.inc.belajar.jpa.entity.CustomerType;
import barokah.inc.belajar.jpa.entity.Member;
import barokah.inc.belajar.jpa.entity.Name;
import barokah.inc.belajar.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

public class P12EmbeddedTest {
    @Test
    void testEmbedded(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Member member = new Member();
        member.setEmail("supriadi@yahoo.com");
        member.setName(new Name());

        member.getName().setTitle("MR");
        member.getName().setFirstName("Yuda");
        member.getName().setMiddleName("Agus");
        member.getName().setLastName("Darmawan");

        entityManager.persist(member);

        entityTransaction.commit();
        entityManager.close();
    }
}
