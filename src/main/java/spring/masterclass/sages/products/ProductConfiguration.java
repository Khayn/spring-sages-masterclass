package spring.masterclass.sages.products;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {

    @Bean
    public ProductRepository productRepository(SessionFactory sessionFactory) {
        return new HibernateProductRepository(sessionFactory);
    }

    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductService(productRepository);
    }

}
