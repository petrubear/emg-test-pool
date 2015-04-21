package emg.demo.pool.parser.pool;

import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import emg.demo.pool.parser.Parser;

public class ParserPool<E, T> extends GenericObjectPool<Parser<E, T>> {
	public ParserPool(PooledObjectFactory<Parser<E, T>> factory) {
		super(factory);
	}

	public ParserPool(PooledObjectFactory<Parser<E, T>> factory,
			GenericObjectPoolConfig config) {
		super(factory, config);
	}
}
