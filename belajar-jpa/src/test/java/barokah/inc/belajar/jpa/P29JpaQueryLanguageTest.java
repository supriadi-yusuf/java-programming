package barokah.inc.belajar.jpa;

import barokah.inc.belajar.jpa.entity.*;
import barokah.inc.belajar.jpa.util.JpaUtil;
import jakarta.persistence.*;
import jakarta.persistence.criteria.*;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class P29JpaQueryLanguageTest {
    @Test
    void testSelect() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Student> typedQuery = entityManager.createQuery("select s from Student s", Student.class);
        List<Student> students = typedQuery.getResultList();

        for (Student student : students) {
            System.out.println(student);
        }

        entityManager.close();
    }

    @Test
    void testWhereClause() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Member> query = entityManager.createQuery("select m from Member m" +
                " where m.name.firstName = :firstName and m.name.lastName = :lastName", Member.class);
        query.setParameter("firstName", "cici");
        query.setParameter("lastName", "putri");

        List<Member> members = query.getResultList();
        for (Member member : members) {
            System.out.println(member.getId() + " : " + member.getFullName());
        }

        entityManager.close();
    }

    @Test
    void testJoin() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Product> query = entityManager.createQuery("select p from Product p join p.brand b" +
                " where b.name = :brandName", Product.class);
        query.setParameter("brandName", "Samsung");

        List<Product> products = query.getResultList();
        for (Product product : products) {
            System.out.println(product.getId() + " : " + product.getName() + " : " + product.getBrand().getName());
        }

        entityManager.close();
    }

    @Test
    void testJoinFetch() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<User> query = entityManager.createQuery("select u from User u join fetch u.likes p" +
                " where p.name = :product", User.class);
        query.setParameter("product", "Tablet");

        List<User> users = query.getResultList();
        for (User user : users) {
            System.out.println("user : " + user.getName());
            for (Product product : user.getLikes()) {
                System.out.println("product : " + product.getName());
            }
            System.out.println("==================================");
        }

        entityManager.close();
    }

    @Test
    void testOrderBy() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Product> query = entityManager.createQuery("select p from Product p order by p.name desc", Product.class);
        List<Product> products = query.getResultList();

        for (Product product : products) {
            System.out.println(product.getName());
        }

        entityManager.close();
    }

    @Test
    void testLimitAndOffset() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Brand> query = entityManager.createQuery("select b from Brand b", Brand.class);
        query.setFirstResult(5); // offset, start from 0
        query.setMaxResults(4); // limit

        List<Brand> brands = query.getResultList();
        for (Brand brand : brands) {
            System.out.println(brand.getId() + " : " + brand.getName());
        }

        entityManager.close();
    }

    @Test
    void testNamedQuery() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Brand> namedQuery = entityManager.createNamedQuery("Brand.findAllByName", Brand.class);
        namedQuery.setParameter("brandName", "Samsung");

        List<Brand> brands = namedQuery.getResultList();
        for (Brand brand : brands) {
            System.out.println(brand.getName());
        }

        entityManager.close();
    }

    @Test
    void testSelectSomeFields() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // if we want to select several fields (not all field) we can use object array
        TypedQuery<Object[]> query = entityManager.createQuery("select b.id, b.name from Brand b where b.name = :brandName", Object[].class);
        query.setParameter("brandName", "Panasonic");

        List<Object[]> objects = query.getResultList();
        for (Object[] object : objects) {
            System.out.println(object[0] + " : " + object[1]);
        }

        entityManager.close();
    }

    @Test
    void testConstructorExpression() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // if we want to select several fields (not all field), better to use constructor expression instead of object array
        TypedQuery<SimpleBrand> query = entityManager.createQuery("select new barokah.inc.belajar.jpa.entity.SimpleBrand( b.id, b.name)" +
                " from Brand b where b.name = :brandName", SimpleBrand.class);
        query.setParameter("brandName", "Aqua");

        List<SimpleBrand> simpleBrands = query.getResultList();
        for (SimpleBrand simpleBrand : simpleBrands) {
            System.out.println(simpleBrand.getId() + " : " + simpleBrand.getName());
        }

        entityManager.close();
    }

    @Test
    void testAggregrate() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Object[]> query = entityManager.createQuery("select min(p.price), max(p.price), avg(p.price) from Product p", Object[].class);

        // result must be single
        Object[] result = query.getSingleResult();

        System.out.println("Min : " + result[0]);
        System.out.println("Max : " + new BigDecimal((double) result[1]).toPlainString());
        System.out.println("Avg : " + result[2]);

        entityManager.close();
    }

    @Test
    void testGroupByAndHaving() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Object[]> query = entityManager.createQuery("select b.id, min(p.price), max(p.price), avg(p.price) from Product p join p.brand b" +
                " group by b.id having min(p.price) >= :min", Object[].class);
        query.setParameter("min", 500_000L);

        List<Object[]> objects = query.getResultList();
        for (Object[] object : objects) {
            System.out.println("brand id : " + object[0]);
            System.out.println("min : " + object[1]);
            System.out.println("max : " + new BigDecimal((double) object[2]).toPlainString());
            System.out.println("avg : " + object[3]);
        }

        entityManager.close();
    }

    @Test
    void testNativeQuery() {
        // native query is not jpa query. it is native sql depends on db provider but it is not recommended.

        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createNativeQuery("select * from brands where name like 'A%'", Brand.class);
        List<Brand> brands = query.getResultList();

        for (Brand brand : brands) {
            System.out.println(brand.getId() + " : " + brand.getName());
        }

        entityManager.close();
    }

    @Test
    void testNamedNativeQuery() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        TypedQuery<Brand> query = entityManager.createNamedQuery("Brand.native.findAll", Brand.class);

        List<Brand> brands = query.getResultList();
        for (Brand brand : brands) {
            System.out.println(brand.getId() + " : " + brand.getName());
        }

        entityManager.close();
    }

    @Test
    void testNonQuery() {
        // we can also use jpa to update record. but it is not recommended.

        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Query query = entityManager.createQuery("update Brand b set b.name = :brandName where b.id = :brandId");
        query.setParameter("brandName", "Samsung Update");
        query.setParameter("brandId", "S01");

        int affectedRecords = query.executeUpdate();

        System.out.println("Success update " + affectedRecords + " records");

        entityTransaction.commit();
        entityManager.close();
    }

    @Test
    void testCriteria() {
        // Criteria is to create dynamic query
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Brand> criteria = builder.createQuery(Brand.class);// result is Brand instance
        Root<Brand> root = criteria.from(Brand.class);//source
        criteria.select(root);

        TypedQuery<Brand> query = entityManager.createQuery(criteria);

        List<Brand> brands = query.getResultList();
        for (Brand brand : brands) {
            System.out.println(brand.getId() + " : " + brand.getName());
        }

        entityManager.close();
    }

    @Test
    void testCriteriaQueryNonEntity() {
        EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
        Root<Brand> b = criteria.from(Brand.class);
        criteria.select(builder.array(b.get("id"), b.get("name")));

        TypedQuery<Object[]> query = entityManager.createQuery(criteria);
        List<Object[]> objects = query.getResultList();
        for (Object[] object : objects) {
            System.out.println(object[0] + " : " + object[1]);
        }

        entityManager.close();
    }

    @Test
    void testCriteriaQueryConstructor() {
        EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = factory.createEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<SimpleBrand> criteria = builder.createQuery(SimpleBrand.class);
        Root<Brand> b = criteria.from(Brand.class);
        criteria.select(builder.construct(SimpleBrand.class, b.get("id"), b.get("name")));

        TypedQuery<SimpleBrand> query = entityManager.createQuery(criteria);
        List<SimpleBrand> simpleBrands = query.getResultList();
        for (SimpleBrand simpleBrand : simpleBrands) {
            System.out.println(simpleBrand.getId() + " : " + simpleBrand.getName());
        }

        entityManager.close();
    }

    @Test
    void testCriteriaQueryWhereClause() {
        EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = factory.createEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Brand> criteria = builder.createQuery(Brand.class);
        Root<Brand> b = criteria.from(Brand.class);
        criteria.select(b);

        criteria.where(
                builder.equal(b.get("name"), "Samsung"), // AND
                builder.isNotNull(b.get("createdAt"))
        );

        TypedQuery<Brand> query = entityManager.createQuery(criteria);
        List<Brand> brands = query.getResultList();
        for (Brand brand : brands) {
            System.out.println(brand.getId() + " : " + brand.getName());
        }

        entityManager.close();
    }

    @Test
    void testCriteriaQueryOr() {
        EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = factory.createEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Brand> criteria = builder.createQuery(Brand.class);
        Root<Brand> b = criteria.from(Brand.class);
        criteria.select(b);

        criteria.where(
                builder.or(
                        builder.equal(b.get("name"), "Samsung"),
                        builder.equal(b.get("name"), "Aqua")
                )
        );

        TypedQuery<Brand> query = entityManager.createQuery(criteria);
        List<Brand> brands = query.getResultList();
        for (Brand brand : brands) {
            System.out.println(brand.getId() + " : " + brand.getName());
        }

        entityManager.close();
    }

    @Test
    void testCriteriaJoin() {
        EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
        Root<Product> p = criteria.from(Product.class);
        Join<Product, Brand> b = p.join("brand");
        criteria.select(p);

        criteria.where(
                builder.equal(b.get("name"), "Samsung")
        );

        TypedQuery<Product> query = entityManager.createQuery(criteria);
        List<Product> products = query.getResultList();
        for (Product product : products) {
            System.out.println(product.getId() + " : " + product.getName());
        }

        entityManager.close();
    }

    @Test
    void testCriteriaJoinFetch() {
        EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
        Root<Product> p = criteria.from(Product.class);
        Fetch<Product, Brand> b = p.fetch("brand");

    }

    @Test
    void testCriteriaParameter() {
        EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = factory.createEntityManager();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Product> criteria = builder.createQuery(Product.class);
        Root<Product> p = criteria.from(Product.class);
        Join<Product, Brand> b = p.join("brand");
        criteria.select(p);

        ParameterExpression<String> nameParameter = builder.parameter(String.class);// String.class is parameter type

        criteria.where(
                builder.equal(b.get("name"), nameParameter)
        );

        TypedQuery<Product> query = entityManager.createQuery(criteria);
        query.setParameter(nameParameter, "Samsung");

        List<Product> products = query.getResultList();
        for (Product product : products) {
            System.out.println(product.getId() + " : " + product.getName());
        }

        entityManager.close();
    }

    @Test
    void testCriteriaAggregate() {
        EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = factory.createEntityManager();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object[]> criteria = builder.createQuery(Object[].class);
        Root<Product> p = criteria.from(Product.class);
        Join<Product, Brand> b = p.join("brand");

        criteria.select(builder.array(
                b.get("name"), builder.min(p.get("price")), builder.max(p.get("price")), builder.avg(p.get("price"))
        ));

        criteria.groupBy(b.get("id"));
        criteria.having(
                builder.greaterThan(builder.min(p.get("price")), 500_000L)
        );

        TypedQuery<Object[]> query = entityManager.createQuery(criteria);
        List<Object[]> results = query.getResultList();
        for (Object[] result : results) {
            System.out.println(result[0] + ", min : " + result[1] + ", max : " +
                    new BigDecimal((double) result[2]).toPlainString() + ", avg : " + result[3]);
        }

        entityManager.close();
    }

    @Test
    void testCriteriaNonQuery() {

        // we can also use JPA QL to update and delete
        EntityManagerFactory factory = JpaUtil.getEntityManagerFactory();
        EntityManager entityManager = factory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Brand> criteria = builder.createCriteriaUpdate(Brand.class);
        Root<Brand> b = criteria.from(Brand.class);

        criteria.set(b.get("name"), "Samsung");
        criteria.where(
                builder.equal(b.get("id"),"S01")
        );

        Query query = entityManager.createQuery(criteria);
        int affectedRows = query.executeUpdate();

        transaction.commit();

        System.out.println("Success updating " + affectedRows + " records");

        entityManager.close();
    }
}
