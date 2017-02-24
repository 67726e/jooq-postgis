package us.hexcoder.jooq.geometry.binding;

import org.jooq.Converter;
import org.postgis.MultiPoint;
import us.hexcoder.jooq.geometry.converter.MultiPointConverter;

/**
 * Created by gnelson on 2/14/17.
 */
public class MultiPointBinding extends PostGISBinding<MultiPoint> {
	@Override
	public Converter<Object, MultiPoint> converter() {
		return new MultiPointConverter();
	}
}
