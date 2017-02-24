package us.hexcoder.jooq.binding;

import org.jooq.Converter;
import org.postgis.MultiPolygon;
import us.hexcoder.jooq.converter.MultiPolygonConverter;

/**
 * Created by gnelson on 2/14/17.
 */
public class MultiPolygonBinding extends PostGISBinding<MultiPolygon> {
	@Override
	public Converter<Object, MultiPolygon> converter() {
		return new MultiPolygonConverter();
	}
}
