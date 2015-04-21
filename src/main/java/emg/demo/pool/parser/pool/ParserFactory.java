package emg.demo.pool.parser.pool;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import emg.demo.pool.parser.Parser;
import emg.demo.pool.parser.impl.XmlParser;

public class ParserFactory<E, T> extends BasePooledObjectFactory<Parser<E, T>> {
	@Override
	public Parser<E, T> create() throws Exception {
		return new XmlParser<E, T>();
	}

	@Override
	public PooledObject<Parser<E, T>> wrap(Parser<E, T> parser) {
		return new DefaultPooledObject<Parser<E, T>>(parser);
	}

	/**
	 * This is used while returning an object back to pool. In the
	 * implementation we can reset the object state, so that the object behaves
	 * as good as a new object on another borrow.
	 */
	@Override
	public void passivateObject(PooledObject<Parser<E, T>> parser)
			throws Exception {
		parser.getObject().reset();
	}

	/**
	 * This is used to validate an object borrowed from the pool or returned to
	 * the pool based on configuration. By default, validation remains off.
	 * Implementing this ensures that client will always get a valid object from
	 * the pool
	 */
	@Override
	public boolean validateObject(PooledObject<Parser<E, T>> parser) {
		return parser.getObject().isValid();
	}
}
