package net.wuollet.jpa.domain.model.location;

import static org.junit.Assert.*;

import org.junit.*;

public class LocationNumberTest extends LocationNumber {

	@Test
	public void testHashCode() {
		LocationNumber l1 = new LocationNumber("A1B2C3");
		LocationNumber l2 = new LocationNumber("A1B2C3");

		assertEquals(l1.hashCode(), l2.hashCode());
	}

	@Test
	public void testLocationNumberNew() {
		LocationNumber l1 = new LocationNumber("A1B2C3");
	}

	@Test(expected=NullPointerException.class)
	public void testNullLocationNumber() {
		new LocationNumber(null);
	}

	@Test
	public void testEqualsObject() {
		LocationNumber l1 = new LocationNumber("A1B2C3");
		LocationNumber l2 = new LocationNumber("A1B2C3");
		LocationNumber l3 = new LocationNumber("XXXXX");

		assertTrue(l1.equals(l2));
		assertFalse(l1.equals(l3));
	}

	@Test
	public void testToString() {
		assertEquals("ABCDE", new LocationNumber("ABCDE").toString());
	}

}
