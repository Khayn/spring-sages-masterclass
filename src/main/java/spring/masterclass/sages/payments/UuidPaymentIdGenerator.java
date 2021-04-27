package spring.masterclass.sages.payments;

import java.util.UUID;

@IdGenerator("uuid")
public class UuidPaymentIdGenerator implements PaymentIdGenerator {

	@Override
	public String getNext() {
		return UUID.randomUUID().toString();
	}
}
