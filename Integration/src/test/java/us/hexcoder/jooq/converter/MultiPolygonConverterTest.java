package us.hexcoder.jooq.converter;

import org.junit.Assert;
import org.junit.Test;
import org.postgis.MultiPolygon;

/**
 * Created by gnelson on 2/14/17.
 */
public class MultiPolygonConverterTest {
	private static final String VALID_MULTIPOLYGON_BINARY = "01060000000200000001030000000200000005000000000000000000" +
			"00000000000000000000000000000000104000000000000000000000000000001040000000000000104000000000000000000000" +
			"0000000010400000000000000000000000000000000005000000000000000000F03F000000000000F03F00000000000000400000" +
			"00000000F03F00000000000000400000000000000040000000000000F03F0000000000000040000000000000F03F000000000000" +
			"F03F01030000000100000005000000000000000000F0BF000000000000F0BF000000000000F0BF00000000000000C00000000000" +
			"0000C000000000000000C000000000000000C0000000000000F0BF000000000000F0BF000000000000F0BF";
	private static final String VALID_MULTIPOLYGON_STRING = "MULTIPOLYGON(((0 0,4 0,4 4,0 4,0 0),(1 1,2 1,2 2,1 2,1 1)),((-1 -1,-1 -2,-2 -2,-2 -1,-1 -1)))";

	public MultiPolygon from(Object object) {
		return new MultiPolygonConverter().from(object);
	}

	public Object to(MultiPolygon multiPolygon) {
		return new MultiPolygonConverter().to(multiPolygon);
	}

	@Test
	public void testFromWithNull() {
		Assert.assertNull(from(null));
	}

	@Test
	public void testFromWithString() throws Exception {
		Assert.assertEquals(new MultiPolygon(VALID_MULTIPOLYGON_STRING), from(VALID_MULTIPOLYGON_BINARY));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFromWithInvalidString() {
		from("???");
	}

	@Test
	public void testToWithNull() {
		Assert.assertNull(to(null));
	}

	@Test
	public void testToWithMultiPolygon() throws Exception {
		Assert.assertEquals(VALID_MULTIPOLYGON_STRING, to(new MultiPolygon(VALID_MULTIPOLYGON_STRING)));
	}
}
