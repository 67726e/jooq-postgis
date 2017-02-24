package us.hexcoder.jooq.converter;

import org.junit.Assert;
import org.junit.Test;
import org.postgis.MultiLineString;

/**
 * Created by gnelson on 2/14/17.
 */
public class MultiLineStringConverterTest {
	private static final String VALID_MULTILINESTRING_BINARY = "01050000000200000001020000000300000000000000000000000" +
			"000000000000000000000000000F03F000000000000F03F000000000000F03F00000000000000400102000000030000000000000" +
			"00000004000000000000008400000000000000840000000000000004000000000000014400000000000001040";
	private static final String VALID_MULTILINESTRING_STRING = "MULTILINESTRING((0 0,1 1,1 2),(2 3,3 2,5 4))";

	public MultiLineString from(Object object) {
		return new MultiLineStringConverter().from(object);
	}

	public Object to(MultiLineString multiLineString) {
		return new MultiLineStringConverter().to(multiLineString);
	}

	@Test
	public void testFromWithNull() {
		Assert.assertNull(from(null));
	}

	@Test
	public void testFromWithString() throws Exception {
		Assert.assertEquals(new MultiLineString(VALID_MULTILINESTRING_STRING), from(VALID_MULTILINESTRING_BINARY));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFromWithInvalidString() {
		from("!!!");
	}

	@Test
	public void testToWithNull() {
		Assert.assertNull(to(null));
	}

	@Test
	public void testToWithMultiPoint() throws Exception {
		Assert.assertEquals(VALID_MULTILINESTRING_STRING, to(new MultiLineString(VALID_MULTILINESTRING_STRING)));
	}
}
