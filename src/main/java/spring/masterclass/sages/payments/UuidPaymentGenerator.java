package spring.masterclass.sages.payments;

import java.util.UUID;

public class UuidPaymentGenerator implements PaymentIdGenerator {

	@Override
	public String getNext() {
		return UUID.randomUUID().toString();
	}
}
