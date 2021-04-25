package spring.masterclass.sages;

import lombok.extern.java.Log;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.masterclass.sages.payments.LocalMoney;
import spring.masterclass.sages.payments.LoggingPaymentService;
import spring.masterclass.sages.payments.PaymentRequest;

@Log
public class Application {
	private static final String BASE_PACKAGE = "spring.masterclass.sages";

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext applicationContext =
					 new AnnotationConfigApplicationContext(BASE_PACKAGE)) {
			var paymentService = applicationContext.getBean(LoggingPaymentService.class);

			var paymentRequest = PaymentRequest.builder()
					.money(LocalMoney.of(1_000))
					.build();

			var payment = paymentService.process(paymentRequest);
			log.info(payment.toString());

		}

	}
}
