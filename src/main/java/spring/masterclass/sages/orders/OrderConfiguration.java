package spring.masterclass.sages.orders;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderConfiguration {

	@Bean
	public OrderRepository orderRepository() {
		return new HashMapOrderRepository();
	}

	@Bean
	public OrderService orderService(OrderRepository orderRepository) {
		return new OrderService(orderRepository);
	}
}
