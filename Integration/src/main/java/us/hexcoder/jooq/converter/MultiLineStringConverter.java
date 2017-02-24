package us.hexcoder.jooq.converter;

import org.postgis.MultiLineString;
import org.postgis.binary.BinaryParser;

/**
 * Created by gnelson on 2/14/17.
 */
public class MultiLineStringConverter extends PostGISConverter<MultiLineString> {
	@Override
	public MultiLineString from(Object databaseObject) {
		if (databaseObject == null) return null;
		else return (MultiLineString) new BinaryParser().parse("" + databaseObject);
	}

	@Override
	public Class<MultiLineString> toType() {
		return MultiLineString.class;
	}
}
