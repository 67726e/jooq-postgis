package us.hexcoder.jooq.binding;

import org.jooq.*;
import org.postgis.Point;
import us.hexcoder.jooq.converter.PointConverter;

/**
 * Created by gnelson on 2/14/17.
 */
public class PointBinding extends PostGISBinding<Point> {
	@Override
	public Converter<Object, Point> converter() {
		return new PointConverter();
	}
}
