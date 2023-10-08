package barokah.inc.belajar.jpa;

import barokah.inc.belajar.jpa.entity.Employee;
import barokah.inc.belajar.jpa.entity.Manager;
import barokah.inc.belajar.jpa.entity.VicePresident;
import barokah.inc.belajar.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P22SingleTableInheritanceTest {
    @Test
    void testCreate(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Employee employee = new Employee();
        employee.setId("K01");
        employee.setName("Abdul Aziz");
        entityManager.persist(employee);

        Manager manager = new Manager();
        manager.setId("K02");
        manager.setName("Imran Hussein");
        manager.setTotalEmployee(100);
        entityManager.persist(manager);

        VicePresident vip = new VicePresident();
        vip.setId("K03");
        vip.setName("Joko Prunomo");
        vip.setTotal_Manager(4);
        entityManager.persist(vip);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void testFind(){
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Employee employee = entityManager.find(Employee.class, "K01");
        Assertions.assertNotNull(employee);

        Manager manager = entityManager.find(Manager.class, "K02");
        Assertions.assertNotNull(manager);

        Employee employee1 = entityManager.find(Employee.class, "K03");
        Assertions.assertNotNull(employee1);

        VicePresident vip = (VicePresident) employee1;
        Assertions.assertEquals("K03",vip.getId());

        entityManager.close();
    }
}
