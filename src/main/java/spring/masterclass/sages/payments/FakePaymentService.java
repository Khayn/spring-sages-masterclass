package spring.masterclass.sages.payments;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;

import java.time.Instant;

@Log
@RequiredArgsConstructor
public class FakePaymentService implements PaymentService {

	private final PaymentIdGenerator paymentGenerator;

	@Override
	public Payment process(PaymentRequest paymentRequest) {


		return Payment.builder()
				.id(paymentGenerator.getNext())
				.money(paymentRequest.getMoney())
				.timestamp(Instant.now())
				.status(PaymentStatus.STARTED)
				.build();
	}

}


