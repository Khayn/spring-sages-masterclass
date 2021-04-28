package spring.masterclass.sages.orders;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.javamoney.moneta.FastMoney;
import spring.masterclass.sages.payments.LocalMoney;
import spring.masterclass.sages.payments.Payment;
import spring.masterclass.sages.products.Product;

import java.util.List;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Order {

	private Long id;

	@NonNull
	private List<Product> products;

	private Payment payment;

	public FastMoney getTotalPrice() {
		return products
				.stream()
				.map(Product::getPrice)
				.reduce(LocalMoney.zero(), FastMoney::add);
	}

}
