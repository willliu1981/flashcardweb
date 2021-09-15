package com.flashcard.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public abstract class ModelWrap {
	private static Properties key;
	private Map<String, Object> map = new HashMap<>();

	public String getKey(String key) {
		return this.key.getProperty(key);
	}

	public void setAddKey(Properties prop) {
		if (this.key == null) {
			this.key = prop;
		}
	}

	public Object getObject(String key) {
		return map.get(key);
	}

	public void addObject(String proxyKey, Object obj) {
		this.map.put(this.key.getProperty(proxyKey), obj);
	}

}
