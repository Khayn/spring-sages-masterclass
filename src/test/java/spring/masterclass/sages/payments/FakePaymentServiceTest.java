package spring.masterclass.sages.payments;

import org.javamoney.moneta.FastMoney;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FakePaymentServiceTest {

	public static final FastMoney MONEY = LocalMoney.of(1_000);

	public static final PaymentRequest PAYMENT_REQUEST = PaymentRequest.builder()
			.money(MONEY)
			.build();

	private static final String PAYMENT_ID = "1";

	@Mock
	private PaymentIdGenerator paymentIdGenerator;

	private Payment payment;

	@BeforeEach
	void setUp() {
		Mockito.when(paymentIdGenerator.getNext()).thenReturn(PAYMENT_ID);

		FakePaymentService fakePaymentService = new FakePaymentService(paymentIdGenerator);
		payment = fakePaymentService.process(PAYMENT_REQUEST);
	}

	@Test
	void shouldAssignGeneratedIdToCreatedPayment() {
		Assertions.assertEquals(PAYMENT_ID, payment.getId());
	}

	@Test
	void shouldAssignMoneyFromPaymentRequestToCreatedPayment() {
		Assertions.assertEquals(MONEY, payment.getMoney());
	}

	@Test
	void shouldAssignTimeStampToCreatedPayment() {
		Assertions.assertNotNull(payment.getTimestamp());
	}

	@Test
	void shouldAssignStartedStatusToCreatedPayment() {
		Assertions.assertEquals(PaymentStatus.STARTED, payment.getStatus());
	}
}