package us.hexcoder.jooq.geometry.converter;

import org.jooq.Converter;

import java.util.Objects;

/**
 * Created by gnelson on 2/14/17.
 */
public abstract class PostGISConverter<U> implements Converter<Object, U> {
	@Override
	public Object to(U userObject) {
		if (userObject == null) return null;
		return Objects.toString(userObject);
	}

	@Override
	public Class<Object> fromType() {
		return Object.class;
	}
}
