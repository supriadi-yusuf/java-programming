package barokah.inc.belajar.jpa;

// unmanage entity : entity is not managed by jpa
// manage entity : entity is managed by jpa
// method persist() and merge() will change object from unmanage entity to manage entity
// method find() will return manage entity
// method detach will change object from manage entity to un manage entity
// after transaction commit() all entity become un manage entity

import barokah.inc.belajar.jpa.entity.Student;
import barokah.inc.belajar.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class P28ManageEntityTest {
    @Test
    void testCreateUnManagedEntity(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Student student = new Student(); // un managed entity

        student.setId("P002");
        student.setName("Imran Kati");
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        entityTransaction.commit(); // commit transaction

        // student with id P002 is not stored to db because it is un managed entity

        entityManager.close();
    }

    @Test
    void testCreateManagedEntity(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Student student = new Student(); // un managed entity

        student.setId("P002");
        student.setName("Imran Kati");
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        entityManager.persist(student); // make it managed entity

        entityTransaction.commit(); // commit transaction

        // student with id P002 is stored to db because it is managed entity

        entityManager.close();
    }

    @Test
    void testUpdateManagedEntity(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Student student = entityManager.find(Student.class, "P001"); // get managed entity
        student.setName("Kulli Mahesa");
        student.setUpdatedAt(LocalDateTime.now());

        entityTransaction.commit(); // commit transaction

        // student with id P001 is stored to db because it is managed entity

        entityManager.close();
    }

    @Test
    void testUpdateUnManagedEntity(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Student student = entityManager.find(Student.class, "P001"); // get managed entity
        entityManager.detach(student); // make it un managed entity

        student.setName("Hello Biyassa");
        student.setUpdatedAt(LocalDateTime.now());

        entityTransaction.commit(); // commit transaction

        // student with id P001 is not stored to db because it is un managed entity

        entityManager.close();
    }

    @Test
    void testUpdateUnManagedEntity2(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Student student = entityManager.find(Student.class, "P001"); // get managed entity

        entityTransaction.commit(); // commit transaction, every managed entity becomes un managed entity

        // update un managed entity
        student.setName("Hello Biyassa");
        student.setUpdatedAt(LocalDateTime.now());

        entityManager.close();

        // student with id P001 is not stored to db because it is un managed entity
    }
}
