package barokah.inc.belajar.jpa;

import barokah.inc.belajar.jpa.entity.Course;
import barokah.inc.belajar.jpa.util.JpaUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.LockModeType;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;
@Slf4j
public class P27PesimisticLockingTest {
    @Test
    void testPesimistic() throws ExecutionException, InterruptedException {
        final EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();

        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<Throwable> testResult = service.submit((Callable<Throwable>) () -> {
            Throwable throwable = null;

            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();

            Course course = entityManager.find(Course.class, "C002", LockModeType.PESSIMISTIC_WRITE);
            course.setName("update 1.");

            entityManager.persist(course);

            try {
                Thread.sleep(8_000L);
                entityTransaction.commit();
                log.info("commit changes 1 ......................");
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

            Course course = entityManager.find(Course.class, "C002", LockModeType.PESSIMISTIC_WRITE);
            course.setName("update 2.");

            entityManager.persist(course);

            entityTransaction.commit();
            log.info("commit changes 2 ......................");
            entityManager.close();
        });

        Throwable throwable = testResult.get();
        service.shutdown();

        Assertions.assertNull(throwable);
    }
}
