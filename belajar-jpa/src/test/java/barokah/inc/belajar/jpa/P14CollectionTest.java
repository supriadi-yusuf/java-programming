package barokah.inc.belajar.jpa;

import barokah.inc.belajar.jpa.entity.Member;
import barokah.inc.belajar.jpa.entity.Name;
import barokah.inc.belajar.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class P14CollectionTest {
    @Test
    void testCreate(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Member member = new Member();
        member.setEmail("sebakul@mail.com");

        member.setName(new Name());
        member.getName().setTitle("mrs");
        member.getName().setFirstName("surya");
        member.getName().setMiddleName("indra");
        member.getName().setLastName("pratama");

        member.setHobbies(new ArrayList<String>());
        member.getHobbies().add("traveling");
        member.getHobbies().add("gaming");
        member.getHobbies().add("watching");

        entityManager.persist(member);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void testUpdate(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Member member = entityManager.find(Member.class, 2);
        member.getHobbies().add("fishing");

        entityManager.merge(member);

        entityTransaction.commit();
        entityManager.close();
    }
}
