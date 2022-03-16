package idv.fc.proxy.interceptor;

import java.util.HashMap;

import idv.fc.exception.FindErrorException;

public class Shuttle extends HashMap<String, Object> {

	public Object getValue(Object key) throws FindErrorException {
		Object o = this.get(key);

		if (o == null) {
			throw new FindErrorException(this.getClass() + ":");
		}

		return o;
	}

}
