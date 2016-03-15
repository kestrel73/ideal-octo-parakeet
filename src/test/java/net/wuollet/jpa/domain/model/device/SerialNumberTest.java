package net.wuollet.jpa.domain.model.device;

import static org.junit.Assert.*;

import org.junit.*;

public class SerialNumberTest {

	@Test
	public void testHashCode() {
		SerialNumber s1 = new SerialNumber("0123456789");
		SerialNumber s2 = new SerialNumber("0123456789");

		assertEquals(s1.hashCode(), s2.hashCode());
	}

	@Test
	public void testSerialNumber() {
		new SerialNumber("0123456789");
		new SerialNumber("E123456789");
		new SerialNumber("EZ23456789");
	}

	@Test(expected=IllegalArgumentException.class)
	public void testInvalidSerialNumber() {
		new SerialNumber("0234");
		new SerialNumber("01234567890");
		new SerialNumber("0A23456789");
		new SerialNumber("01-3456789");
		new SerialNumber(" 0123456789");
		new SerialNumber("0123456789 ");
		new SerialNumber("EBC3456789");
		new SerialNumber(null);

	}

	@Test
	public void testEqualsObject() {
		SerialNumber s1 = new SerialNumber("0123456789");
		SerialNumber s2 = new SerialNumber("0123456789");
		SerialNumber s3 = new SerialNumber("1123456789");

		assertTrue(s1.equals(s2));
		assertFalse(s1.equals(s3));
	}

}
