package spring.masterclass.sages.payments;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UuidPaymentIdGeneratorTest {

	private static final String ID_FORMAT = "\\w{8}-\\w{4}-\\w{4}-\\w{4}-\\w{12}";

	private final UuidPaymentIdGenerator uut = new UuidPaymentIdGenerator();

	@DisplayName("Should generate valid id")
	@Test
	void shouldGenerateValidId() {
		//given + when
		String actual = uut.getNext();

		//then
		assertTrue(actual.matches(ID_FORMAT));
	}
}