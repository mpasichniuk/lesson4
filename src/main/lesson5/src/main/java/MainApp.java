import org.hibernate.HibernateException;
import org.hibernate.cfg.Configuration;
import org.hibernate.sql.ast.tree.predicate.Predicate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

        EntityManager entityManager = entityManagerFactory.createEntityManager();


        List<ProductSpringDTO> products = entityManager.createQuery("""
                        select u from Product u
                        where (u.productTitle like : productTitleFilter)
                         and u.cost like :costFilter
                        """, ProductSpringDTO.class)
                .setParameter("productTitleFilter", "%U%")
                .setParameter("costFilter", "%c%")
                .getResultList();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductSpringDTO> query = cb.createQuery(ProductSpringDTO.class);
        Root<ProductSpringDTO> root = query.from(ProductSpringDTO.class);
        Join<Object, Object> contacts = root.join("contacts");

        List<Predicate> predicates = new ArrayList<>();
        predicates.add((Predicate) cb.like(root.get("productTitle"), "%U%"));
        predicates.add((Predicate) cb.like(root.get("cost"), "%c%"));


        List<ProductSpringDTO> resultList = entityManager.createQuery(query
                        .select(root)
                        .where((javax.persistence.criteria.Predicate) predicates.toArray(new Predicate[0])))
                .getResultList();


        System.out.println();



        entityManager.close();
        entityManagerFactory.close();


    }
}

