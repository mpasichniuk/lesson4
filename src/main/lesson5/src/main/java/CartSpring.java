import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@Scope("prototype")
public class CartSpring {
    private Set<ProductSpringDTO> cartSpring = new HashSet<>();

    public void add(ProductSpringDTO productSpringDTO) {
        cartSpring.add(productSpringDTO);
    }

    public void remove(ProductSpringDTO productSpringDTO) {
        cartSpring.remove(productSpringDTO);
    }

    public List<ProductSpringDTO> getAllProductsSpringDTO() {
        return new ArrayList<>(cartSpring);
    }
}

