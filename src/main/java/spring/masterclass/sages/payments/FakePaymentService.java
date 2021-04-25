package spring.masterclass.sages.payments;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
public class FakePaymentService implements PaymentService {
	private final PaymentIdGenerator paymentGenerator;

	@LogPayments
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


