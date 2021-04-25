package spring.masterclass.sages.payments;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UuidPaymentGenerator implements PaymentIdGenerator {

	@Override
	public String getNext() {
		return UUID.randomUUID().toString();
	}
}
