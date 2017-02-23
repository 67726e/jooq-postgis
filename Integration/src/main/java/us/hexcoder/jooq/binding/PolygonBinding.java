package us.hexcoder.jooq.binding;

import org.jooq.Converter;
import org.postgis.Polygon;
import us.hexcoder.jooq.converter.PolygonConverter;

/**
 * Created by gnelson on 2/14/17.
 */
public class PolygonBinding extends PostGISBinding<Polygon> {
	@Override
	public Converter<Object, Polygon> converter() {
		return new PolygonConverter();
	}
}
