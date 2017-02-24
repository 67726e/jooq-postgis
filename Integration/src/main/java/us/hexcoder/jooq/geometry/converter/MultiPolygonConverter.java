package us.hexcoder.jooq.geometry.converter;

import org.postgis.MultiPolygon;
import org.postgis.binary.BinaryParser;

/**
 * Created by gnelson on 2/14/17.
 */
public class MultiPolygonConverter extends PostGISConverter<MultiPolygon> {
	@Override
	public MultiPolygon from(Object databaseObject) {
		if (databaseObject == null) return null;
		else return (MultiPolygon) new BinaryParser().parse("" + databaseObject);
	}

	@Override
	public Class<MultiPolygon> toType() {
		return MultiPolygon.class;
	}
}
