package spring.masterclass.sages.payments;

import org.javamoney.moneta.FastMoney;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.Instant;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class HashMapPaymentRepositoryTest {

	private static final String PAYMENT_ID = "1";

	private static final FastMoney MONEY = LocalMoney.of(1_000);

	Payment PAYMENT = Payment.builder()
			.id(PAYMENT_ID)
			.money(MONEY)
			.timestamp(Instant.now())
			.status(PaymentStatus.STARTED)
			.build();

	@Mock
	private Map<String, Payment> payments;
	private HashMapPaymentRepository uut = new HashMapPaymentRepository();

	@BeforeEach
	void setUp() {
		uut.setPayments(payments);
	}

	@Test
	void shouldAddPaymentToHashMapUnderPaymentId() {
		//given + when
		uut.save(PAYMENT);

		//then
		Mockito.verify(payments).put(PAYMENT_ID, PAYMENT);
	}

	@Test
	void shouldAddAndReturnSavedPayment() {
		//given + when
		Payment actual = uut.save(PAYMENT);

		//then
		assertEquals(PAYMENT, actual);
	}
}