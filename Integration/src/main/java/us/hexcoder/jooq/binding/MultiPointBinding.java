package us.hexcoder.jooq.binding;

import org.jooq.Converter;
import org.postgis.MultiPoint;
import us.hexcoder.jooq.converter.MultiPointConverter;

/**
 * Created by gnelson on 2/14/17.
 */
public class MultiPointBinding extends PostGISBinding<MultiPoint> {
	@Override
	public Converter<Object, MultiPoint> converter() {
		return new MultiPointConverter();
	}
}
