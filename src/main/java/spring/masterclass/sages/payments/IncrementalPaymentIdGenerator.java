package spring.masterclass.sages.payments;

import lombok.Setter;

@IdGenerator("incremental")
public class IncrementalPaymentIdGenerator implements PaymentIdGenerator {

	public static final String ID_FORMAT = "%010d";

	@Setter
	private long index;

	@Override
	public String getNext() {
		return String.format(ID_FORMAT, ++index);
	}
}
