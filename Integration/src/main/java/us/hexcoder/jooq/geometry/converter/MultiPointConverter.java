package us.hexcoder.jooq.geometry.converter;

import org.postgis.MultiPoint;
import org.postgis.binary.BinaryParser;

/**
 * Created by gnelson on 2/14/17.
 */
public class MultiPointConverter extends PostGISConverter<MultiPoint> {
	@Override
	public MultiPoint from(Object databaseObject) {
		if (databaseObject == null) return null;
		else return (MultiPoint) new BinaryParser().parse("" + databaseObject);
	}

	@Override
	public Class<MultiPoint> toType() {
		return MultiPoint.class;
	}
}
