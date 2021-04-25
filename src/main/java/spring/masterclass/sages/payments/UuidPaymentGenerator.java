package spring.masterclass.sages.payments;

import java.util.UUID;

public class UuidPaymentGenerator {

	public String getNext(){
		return UUID.randomUUID().toString();
	}
}
