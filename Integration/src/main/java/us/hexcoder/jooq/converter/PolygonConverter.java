package us.hexcoder.jooq.converter;

import org.postgis.Polygon;
import org.postgis.binary.BinaryParser;

/**
 * Created by gnelson on 2/14/17.
 */
public class PolygonConverter extends PostGISConverter<Polygon> {
	@Override
	public Polygon from(Object databaseObject) {
		if (databaseObject == null) return null;
		else return (Polygon) new BinaryParser().parse("" + databaseObject);
	}

	@Override
	public Class<Polygon> toType() {
		return Polygon.class;
	}
}
