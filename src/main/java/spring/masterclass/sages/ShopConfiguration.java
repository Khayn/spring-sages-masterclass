package spring.masterclass.sages;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import spring.masterclass.sages.orders.OrderService;
import spring.masterclass.sages.payments.PaymentService;
import spring.masterclass.sages.products.ProductService;

import javax.sql.DataSource;

@PropertySource("classpath:jdbc.properties")
@Configuration
public class ShopConfiguration {

    @Bean
    public ShopService shopService(OrderService orderService, PaymentService paymentService,
                                   ProductService productService) {

        return new ShopService(orderService, paymentService, productService);
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }

    @Bean
    public DataSource dataSource(Environment environment) {
        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setUsername(environment.getProperty("database.username"));
        dataSource.setPassword(environment.getProperty("database.password"));
        dataSource.setJdbcUrl(environment.getProperty("database.url"));
        dataSource.setDriverClassName(environment.getProperty("database.driver"));

        return dataSource;

    }


}
