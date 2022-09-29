import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductSpringRepositoryImpl extends ProductRepository {
    private final Map<Long, ProductSpringDTO> productMap = new HashMap<>();

    public ProductSpringRepositoryImpl(EntityManagerFactory emFactory) {
        super(emFactory);
    }

    public ProductSpringRepositoryImpl() {
        super();
    }


    @PostConstruct
    public void init() {
        addProductSpringDTO(1L, new ProductSpringDTO("product1", 1L, 50,24));
        addProductSpringDTO(2L, new ProductSpringDTO("product2", 2, 10, 56 ));
        addProductSpringDTO(3L, new ProductSpringDTO("product3", 3, 40, 89));
        addProductSpringDTO(4L, new ProductSpringDTO("product4", 4, 20, 678));
        addProductSpringDTO(5L, new ProductSpringDTO("product5", 5, 30, 4565));
    }

    @Override
    public ProductSpringDTO findProductSpringDTOById(Long id) {
        return productMap.get(id);
    }

    @Override
    public void addProductSpringDTO(Long id, ProductSpringDTO productSpring) {
        productMap.put(id, productSpring);
    }
}

