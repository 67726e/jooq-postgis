package us.hexcoder.jooq.converter;

import org.postgis.LineString;
import org.postgis.binary.BinaryParser;

/**
 * Created by gnelson on 2/14/17.
 */
public class LineStringConverter extends PostGISConverter<LineString> {
	@Override
	public LineString from(Object databaseObject) {
		if (databaseObject == null) return null;
		else return (LineString) new BinaryParser().parse("" + databaseObject);
	}

	@Override
	public Class<LineString> toType() {
		return LineString.class;
	}
}
