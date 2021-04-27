package spring.masterclass.sages.payments;

import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.time.Instant;

@Log
@Service("paymentService")
public class FakePaymentService implements PaymentService {

	private final PaymentIdGenerator paymentGenerator;

	private final PaymentRepository paymentRepository;

	public FakePaymentService(@IdGenerator("uuid") PaymentIdGenerator paymentGenerator,
							  PaymentRepository paymentRepository) {
		this.paymentGenerator = paymentGenerator;
		this.paymentRepository = paymentRepository;
	}

	@LogPayments
	@Override
	public Payment process(PaymentRequest paymentRequest) {
		var payment = Payment.builder()
				.id(paymentGenerator.getNext())
				.money(paymentRequest.getMoney())
				.timestamp(Instant.now())
				.status(PaymentStatus.STARTED)
				.build();

		return paymentRepository.save(payment);
	}

	@PostConstruct
	public void init() {
		log.info("PaymentService initialized.");
	}

	@PreDestroy
	public void destroy() {
		log.info("PaymentService is going down.");
	}
}


