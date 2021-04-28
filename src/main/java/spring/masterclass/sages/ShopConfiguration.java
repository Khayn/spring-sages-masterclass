package spring.masterclass.sages;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import spring.masterclass.sages.orders.OrderService;
import spring.masterclass.sages.payments.PaymentService;
import spring.masterclass.sages.products.ProductService;

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
}
