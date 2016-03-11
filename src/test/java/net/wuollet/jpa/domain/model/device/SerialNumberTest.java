package net.wuollet.jpa.domain.model.device;

import org.junit.*;

public class SerialNumberTest {

	@Test
	public void testHashCode() {
		//fail("Not yet implemented");
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
		//fail("Not yet implemented");
	}

}
