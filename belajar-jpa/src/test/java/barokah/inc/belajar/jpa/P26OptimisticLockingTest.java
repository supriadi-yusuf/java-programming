package barokah.inc.belajar.jpa;

import barokah.inc.belajar.jpa.entity.Course;
import barokah.inc.belajar.jpa.entity.Student;
import barokah.inc.belajar.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.*;

public class P26OptimisticLockingTest {
    @Test
    void create() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Course course = new Course();
        course.setId("C002");
        course.setName("PHP");
        course.setStudents(110);

        entityManager.persist(course);

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void testUpdateStudent() throws InterruptedException, ExecutionException {

        final EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();

        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<Throwable> testResult = service.submit((Callable<Throwable>) () -> {
            Throwable throwable = null;

            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Course course = entityManager.find(Course.class, "C001");
            course.setName("update 1");

            entityManager.persist(course);

            try {
                Thread.sleep(8_000L);
                entityTransaction.commit();
            } catch (Throwable e) {
                throwable = e;
                System.out.println(e.getMessage());
            }finally {
                entityManager.close();
            }

            return throwable;
        });

        service.submit((Runnable) ()->{
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Course course = entityManager.find(Course.class, "C001");
            course.setName("update 2");

            entityManager.persist(course);

            entityTransaction.commit();
            entityManager.close();
        });

        Throwable throwable = testResult.get();
        service.shutdown();

        Assertions.assertNotNull(throwable);
    }


}
