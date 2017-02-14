package us.hexcoder.jooq.converter;

import org.jooq.Converter;
import org.postgis.Point;
import org.postgis.binary.BinaryParser;

/**
 * Created by gnelson on 2/14/17.
 */
public class PointConverter implements Converter<Object, Point> {
	@Override
	public Point from(Object databaseObject) {
		if (databaseObject == null) return null;
		else return ((Point) new BinaryParser().parse("" + databaseObject));
	}

	@Override
	public Object to(Point userObject) {
		if (userObject == null) return null;
		else return userObject.toString();
	}

	@Override
	public Class<Object> fromType() {
		return Object.class;
	}

	@Override
	public Class<Point> toType() {
		return Point.class;
	}
}
