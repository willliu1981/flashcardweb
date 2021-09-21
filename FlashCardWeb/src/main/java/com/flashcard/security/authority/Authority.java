package com.flashcard.security.authority;

import java.util.HashMap;
import java.util.Map;

public abstract class Authority<T> {

	private Map<String, T> keyMap = new HashMap<>();

	public void init() {
		setConfig();
	}

	public void put(String key, T t) {
		this.keyMap.put(key, t);
	}

	public T get(String key) {
		return this.keyMap.get(key);
	}

	abstract protected void setKeys(String name, T... keys);

	abstract protected void setKeys(String name, String inheritedAuthority,
			T... keys);

	abstract protected void setConfig();

	abstract public T getKey(String authName);
	
	public abstract boolean hasKey(String authorityName, T matchKey);
	public abstract boolean hasKey(String authorityName, String matchKey);

}
