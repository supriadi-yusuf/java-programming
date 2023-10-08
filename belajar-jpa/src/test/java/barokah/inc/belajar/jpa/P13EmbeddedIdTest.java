package barokah.inc.belajar.jpa;

import barokah.inc.belajar.jpa.entity.Department;
import barokah.inc.belajar.jpa.entity.DepartmentId;
import barokah.inc.belajar.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P13EmbeddedIdTest {
    @Test
    void testInsert(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Department departement = new Department();
        departement.setName("Teknik");
        departement.setId(new DepartmentId());

        departement.getId().setDepartementId("tek");
        departement.getId().setCompanyId("inc");

        entityManager.persist(departement);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void testFind(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        DepartmentId departementId = new DepartmentId();
        departementId.setCompanyId("inc");
        departementId.setDepartementId("tek");

        Department departement = entityManager.find(Department.class, departementId);
        Assertions.assertNotNull(departement);

        entityManager.close();
    }
}
