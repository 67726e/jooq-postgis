package us.hexcoder.jooq.geometry.binding;

import org.jooq.*;
import org.jooq.impl.DSL;

import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Types;
import java.util.Objects;

/**
 * Created by gnelson on 2/14/17.
 */
public abstract class PostGISBinding<U> implements Binding<Object, U> {
	public abstract Converter<Object, U> converter();

	@Override
	public void sql(BindingSQLContext<U> context) throws SQLException {
		context.render().visit(DSL.val(context.convert(converter()).value())).sql("::geometry");
	}

	@Override
	public void register(BindingRegisterContext<U> context) throws SQLException {
		context.statement().registerOutParameter(context.index(), Types.VARCHAR);
	}

	@Override
	public void set(BindingSetStatementContext<U> context) throws SQLException {
		context.statement().setString(context.index(), Objects.toString(context.convert(converter()).value(), null));
	}

	@Override
	public void set(BindingSetSQLOutputContext<U> context) throws SQLException {
		throw new SQLFeatureNotSupportedException(); // TODO: Just WTF does this method do?
	}

	@Override
	public void get(BindingGetResultSetContext<U> context) throws SQLException {
		context.convert(converter()).value(context.resultSet().getString(context.index()));
	}

	@Override
	public void get(BindingGetStatementContext<U> context) throws SQLException {
		context.convert(converter()).value(context.statement().getString(context.index()));
	}

	@Override
	public void get(BindingGetSQLInputContext<U> context) throws SQLException {
		throw new SQLFeatureNotSupportedException(); // TODO: Just WTF does this method do?
	}
}
