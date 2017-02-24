package us.hexcoder.jooq.binding;

import org.jooq.Converter;
import org.postgis.MultiLineString;
import us.hexcoder.jooq.converter.MultiLineStringConverter;

/**
 * Created by gnelson on 2/14/17.
 */
public class MultiLineStringBinding extends PostGISBinding<MultiLineString> {
	@Override
	public Converter<Object, MultiLineString> converter() {
		return new MultiLineStringConverter();
	}
}
