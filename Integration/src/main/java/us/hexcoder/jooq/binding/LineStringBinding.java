package us.hexcoder.jooq.binding;

import org.jooq.Converter;
import org.postgis.LineString;
import us.hexcoder.jooq.converter.LineStringConverter;

/**
 * Created by gnelson on 2/14/17.
 */
public class LineStringBinding extends PostGISBinding<LineString> {
	@Override
	public Converter<Object, LineString> converter() {
		return new LineStringConverter();
	}
}
