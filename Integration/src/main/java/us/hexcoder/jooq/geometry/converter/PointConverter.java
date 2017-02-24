package us.hexcoder.jooq.geometry.converter;

import org.postgis.Point;
import org.postgis.binary.BinaryParser;

/**
 * Created by gnelson on 2/14/17.
 */
public class PointConverter extends PostGISConverter<Point> {
	@Override
	public Point from(Object databaseObject) {
		if (databaseObject == null) return null;
		else return ((Point) new BinaryParser().parse("" + databaseObject));
	}

	@Override
	public Class<Point> toType() {
		return Point.class;
	}
}
