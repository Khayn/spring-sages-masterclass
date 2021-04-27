package spring.masterclass.sages.payments;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.lang.Long.parseLong;

class IncrementalPaymentIdGeneratorTest {

	public static final String ID_FORMAT = "\\d{10}";

	private final IncrementalPaymentIdGenerator uut = new IncrementalPaymentIdGenerator();

	@DisplayName("Should generate valid id")
	@Test
	void shouldGenerateValidId() {
		//given + when
		String actual = uut.getNext();

		//then
		Assertions.assertTrue(actual.matches(ID_FORMAT));
	}

	@DisplayName("Should generate id by incrementing id of previous one")
	@Test
	void shouldGenerateIdByIncrementingValueOfPreviousOne() {
		//given + when
		long firstIdValue = parseLong(uut.getNext());
		long secondIdValue = parseLong(uut.getNext());

		//then
		Assertions.assertEquals(firstIdValue + 1L, secondIdValue);
	}
}