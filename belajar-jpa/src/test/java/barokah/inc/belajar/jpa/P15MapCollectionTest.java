package barokah.inc.belajar.jpa;

import barokah.inc.belajar.jpa.entity.Member;
import barokah.inc.belajar.jpa.entity.Name;
import barokah.inc.belajar.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class P15MapCollectionTest {
    @Test
    void testCreate(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Member member = new Member();
        member.setEmail("sakura@mail.com");

        member.setName(new Name());
        member.getName().setTitle("mrs");
        member.getName().setFirstName("cici");
        member.getName().setMiddleName("tukimin");
        member.getName().setLastName("putri");

        member.setHobbies(new ArrayList<String>());
        member.getHobbies().add("coding");
        member.getHobbies().add("gaming");

        member.setSkills(new HashMap<>());
        member.getSkills().put("Java",90);
        member.getSkills().put("C",80);
        member.getSkills().put("Golang",80);

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

        Member member = entityManager.find(Member.class, 7);

        member.getHobbies().add("swimming");
        member.getHobbies().add("camping");

        member.getSkills().put("Java",90);
        member.getSkills().put("C",80);
        member.getSkills().put("PHP",80);
        member.getSkills().put("Golang",80);

        entityManager.merge(member);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void testDelete(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Member member = entityManager.find(Member.class, 7);

        entityManager.remove(member);

        entityTransaction.commit();
        entityManager.close();
    }
}
