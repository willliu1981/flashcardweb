package tool;

import java.util.HashMap;
import java.util.Map;

public class MapperMap {

	public static class InnerMapperMap extends HashMap<String, Object> {

		public InnerMapperMap put(String key, Object value) {
			super.put(key, value);
			return this;
		}
	}

	public static InnerMapperMap put(String key, Object value) {
		InnerMapperMap map = new InnerMapperMap();
		map.put(key, value);
		return map;
	}

}
