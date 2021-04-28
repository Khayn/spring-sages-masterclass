package spring.masterclass.sages;

import lombok.extern.java.Log;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.masterclass.sages.orders.Order;
import spring.masterclass.sages.payments.LocalMoney;
import spring.masterclass.sages.products.Product;
import spring.masterclass.sages.products.ProductType;

import java.util.List;

@Log
public class Application {

	public static final Product VIDEO_PRODUCT = Product
			.builder()
			.name("Spring masterclass")
			.description("Praktyczny kurs Spring framework")
			.type(ProductType.VIDEO)
			.price(LocalMoney.of(799))
			.build();

	public static final Product BOOK_PRODUCT = Product
			.builder()
			.name("Spring guide")
			.description("Praktyczne ćwiczenia do samodzielnego wykonania")
			.type(ProductType.VIDEO)
			.price(LocalMoney.of(200))
			.build();

	private static final String BASE_PACKAGE = "spring.masterclass.sages";

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext applicationContext =
					 new AnnotationConfigApplicationContext(BASE_PACKAGE)) {

			var shopService = applicationContext.getBean(ShopService.class);
			shopService.addProduct(VIDEO_PRODUCT);
			shopService.addProduct(BOOK_PRODUCT);

			log.info(shopService.getProducts(0, 100).toString());

			var order = new Order(List.of(VIDEO_PRODUCT, BOOK_PRODUCT));
			shopService.placeOrder(order);

			var payment = shopService.payForOrder(order.getId());
			log.info(payment.getId());

		}

	}
}
