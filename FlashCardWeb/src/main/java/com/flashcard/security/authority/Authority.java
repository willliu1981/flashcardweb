package com.flashcard.security.authority;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import com.flashcard.security.authorization.Authorizations;

public abstract class Authority {

	protected Map<String, Integer> keyMap = new HashMap<>();

	protected Authority() {
		setConfig();
	}

	protected void setKeys(String name, Integer... keys) {
		this.keyMap.put(name, Authorizations.combineKey(keys));
	}

	protected void setKeys(String name, String inheritedAuthority, Integer... keys) {

		this.keyMap.put(name,
				Authorizations.combineKey(
						Stream.of(Stream.of(this.keyMap.get(inheritedAuthority)), Stream.of(keys))
								.flatMap(x -> x).toArray(x -> new Integer[keys.length + 1])));
	}

	abstract protected void setConfig();

	abstract public Integer getAuthorityKey(String authName);

}
