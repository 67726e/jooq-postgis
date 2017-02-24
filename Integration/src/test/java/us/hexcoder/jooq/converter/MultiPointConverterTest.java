package us.hexcoder.jooq.converter;

import org.junit.Assert;
import org.junit.Test;
import org.postgis.MultiPoint;

/**
 * Created by gnelson on 2/14/17.
 */
public class MultiPointConverterTest {
	private static final String VALID_MULTIPOINT_BINARY = "0104000000020000000101000000000000000000000000000000000000" +
			"000101000000000000000000F03F0000000000000040";
	private static final String VALID_MULTIPOINT_STRING = "MULTIPOINT(0 0,1 2)";

	public MultiPoint from(Object object) {
		return new MultiPointConverter().from(object);
	}

	public Object to(MultiPoint multiPoint) {
		return new MultiPointConverter().to(multiPoint);
	}

	@Test
	public void testFromWithNull() {
		Assert.assertNull(from(null));
	}

	@Test
	public void testFromWithString() throws Exception {
		Assert.assertEquals(new MultiPoint(VALID_MULTIPOINT_STRING), from(VALID_MULTIPOINT_BINARY));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFromWithInvalidString() {
		from("Wu-Tang");
	}

	@Test
	public void testToWithNull() {
		Assert.assertNull(to(null));
	}

	@Test
	public void testToWithMultiPoint() throws Exception {
		Assert.assertEquals(VALID_MULTIPOINT_STRING, to(new MultiPoint(VALID_MULTIPOINT_STRING)));
	}
}
