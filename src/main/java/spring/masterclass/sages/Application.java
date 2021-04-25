package spring.masterclass.sages;

import lombok.extern.java.Log;
import spring.masterclass.sages.payments.FakePaymentService;
import spring.masterclass.sages.payments.IncrementalPaymentIdGenerator;
import spring.masterclass.sages.payments.LocalMoney;
import spring.masterclass.sages.payments.PaymentRequest;

@Log
public class Application {

	public static void main(String[] args) {
		var paymentIdGenerator = new IncrementalPaymentIdGenerator();
		var paymentService = new FakePaymentService(paymentIdGenerator);

		var paymentRequest = PaymentRequest.builder()
				.money(LocalMoney.of(1_000))
				.build();

		var payment = paymentService.process(paymentRequest);
		log.info(payment.toString());
	}
}
