import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope("prototype")
public class CartSpringService {

    

    public CartSpringService(ProductRepository productSpringRepository) {


        this.productSpringRepository = productSpringRepository;
    }

    private final CartSpring cartSpring = new CartSpring();
    private final ProductRepository productSpringRepository;
    public void addProductSpringDTOToCart(Long id) {
            ProductSpringDTO productSpring = productSpringRepository.findProductSpringDTOById(id);
            cartSpring.add(productSpring);
        }

        public void removeProductSpringDTOFromCart(Long productSpringDTOId) {
            ProductSpringDTO productSpring = productSpringRepository.findProductSpringDTOById(productSpringDTOId);
            cartSpring.remove(productSpring);
        }

        public List<ProductSpringDTO> getCartSpringProducts() {
            return cartSpring.getAllProductsSpringDTO();
        }


    }


