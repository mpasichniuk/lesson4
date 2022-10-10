import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
@Configuration
@ComponentScan("main")
public class App {


    @Bean
    public ProductRepository productSpringRepository() {
        return new ProductSpringRepositoryImpl();
    }

    @Bean
    @Scope("prototype")
    public CartSpring cartSpring() {
        return new CartSpring();
    }
    @Bean
    public CartSpringService cartSpringService(ProductRepository productRepository) {
        return new CartSpringService(productRepository);
    }
}

