package us.hexcoder.jooq.converter;

import org.junit.Assert;
import org.junit.Test;
import org.postgis.Polygon;

import java.util.logging.Logger;

/**
 * Created by gnelson on 2/14/17.
 */
public class PolygonConverterTest {
	private static final String VALID_POLYGON_BINARY = "0103000000010000000500000000000000000000000000000000000000000" +
			"000000000F03F0000000000000000000000000000F03F000000000000F03F0000000000000000000000000000F03F00000000000" +
			"000000000000000000000";
	private static final String VALID_POLYGON_TEXT = "POLYGON((0 0,1 0,1 1,0 1,0 0))";

	public Polygon from(Object object) {
		return new PolygonConverter().from(object);
	}

	public Object to(Polygon polygon) {
		return new PolygonConverter().to(polygon);
	}

	@Test
	public void testFromWithNull() {
		Assert.assertNull(from(null));
	}

	@Test
	public void testFromWithString() throws Exception {
		Polygon polygon = from(VALID_POLYGON_BINARY);

		Assert.assertEquals(new Polygon(VALID_POLYGON_TEXT), polygon);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFromWithInvalidString() {
		from("Well, fuck.");
	}

	@Test
	public void testToWithNull() {
		Assert.assertNull(to(null));
	}

	@Test
	public void testToWithPolygon() throws Exception {
		Polygon polygon = new Polygon(VALID_POLYGON_TEXT);

		Assert.assertEquals(VALID_POLYGON_TEXT, to(polygon));
	}
}
