package us.hexcoder.jooq.converter;

import org.junit.Assert;
import org.junit.Test;
import org.postgis.LineString;

/**
 * Created by gnelson on 2/14/17.
 */
public class LineStringConverterTest {
	private static final String VALID_LINESTRING_BINARY = "0102000000040000000000000000000000000000000000000000000000" +
			"0000F03F000000000000F03F0000000000000040000000000000F03F00000000000000400000000000000040";
	private static final String VALID_LINESTRING_STRING = "LINESTRING(0 0,1 1,2 1,2 2)";

	public LineString from(Object object) {
		return new LineStringConverter().from(object);
	}

	public Object to(LineString lineString) {
		return new LineStringConverter().to(lineString);
	}

	@Test
	public void testFromWithNull() {
		Assert.assertNull(from(null));
	}

	@Test
	public void testFromWithString() throws Exception {
		Assert.assertEquals(new LineString(VALID_LINESTRING_STRING), from(VALID_LINESTRING_BINARY));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFromWithInvalidString() {
		from("WTF?!");
	}

	@Test
	public void testToWithNull() {
		Assert.assertNull(to(null));
	}

	@Test
	public void testToWithLinestring() throws Exception {
		Assert.assertEquals(VALID_LINESTRING_STRING, to(new LineString(VALID_LINESTRING_STRING)));
	}
}
