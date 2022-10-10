import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class ProductRepository {
    private EntityManagerFactory emFactory;

    public ProductRepository(EntityManagerFactory emFactory) {
        this.emFactory = emFactory;
    }

    public ProductRepository() {

    }

    public Optional<ProductSpringDTO> findById(long id) {
        return executeForEntityManager(entityManager ->
                Optional.ofNullable(entityManager.find(ProductSpringDTO.class, id)));
    }

    public List<ProductSpringDTO> findAll() {
        return executeForEntityManager(entityManager ->
                entityManager.createNamedQuery("findAllProducts", ProductSpringDTO.class).getResultList());
    }

    public long count() {
        return executeForEntityManager(entityManager ->
                entityManager.createNamedQuery("countAllProducts", Long.class).getSingleResult());
    }

    public void save(ProductSpringDTO productSDTO) {
        executeInTransaction(entityManager -> {
            if (productSDTO.getId() == null) {
                entityManager.persist(productSDTO);
            } else {
                entityManager.merge(productSDTO);
            }
        });
    }

    public void delete(long id) {
        executeInTransaction(entityManager -> entityManager.createNamedQuery("deleteProductById")
                .setParameter("id", id)
                .executeUpdate());
    }

    private <R> R executeForEntityManager(Function<EntityManager, R> function) {
        EntityManager em = emFactory.createEntityManager();
        try {
            return function.apply(em);
        } finally {
            em.close();
        }
    }

    private void executeInTransaction(Consumer<EntityManager> consumer) {
        EntityManager em = emFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            consumer.accept(em);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public ProductSpringDTO findProductSpringDTOById(Long productSpringDTOId) {


        return null;
    }

    public abstract void addProductSpringDTO(Long id, ProductSpringDTO productSpring);
}

