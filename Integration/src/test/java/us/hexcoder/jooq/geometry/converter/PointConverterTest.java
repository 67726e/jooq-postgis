package us.hexcoder.jooq.geometry.converter;

import org.junit.Assert;
import org.junit.Test;
import org.postgis.Point;

/**
 * Created by gnelson on 2/14/17.
 */
public class PointConverterTest {
	private static final String VALID_POINT_BINARY = "01010000000000000000000040000000000000F03F";
	private static final String VALID_POINT_TEXT = "POINT(2 1)";

	public Point from(Object object) {
		return new PointConverter().from(object);
	}

	public Object to(Point point) {
		return new PointConverter().to(point);
	}

	@Test
	public void testFromWithNull() {
		Assert.assertNull(from(null));
	}

	@Test
	public void testFromWithString() {
		Assert.assertEquals(new Point(2, 1), from(VALID_POINT_BINARY));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFromWithRawPoint() {
		from("(1, 2)");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFromWithInvalidString() {
		from("Nein! Nein! Nein!");
	}

	@Test
	public void testToWithNull() {
		Assert.assertNull(to(null));
	}

	@Test
	public void testToWithPoint() {
		Object object = to(new Point(2, 1));

		Assert.assertEquals(VALID_POINT_TEXT, object);
	}
}
