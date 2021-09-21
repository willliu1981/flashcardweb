package com.flashcard.security.authority;

import java.util.stream.Stream;

import com.flashcard.security.authorization.Authorizations;

public abstract class AuthorityAdapter extends Authority<Integer> {

	@Override
	public Integer getKey(String authName) {
		return this.get(authName);
	}

	protected void setKeys(String name, Integer... keys) {
		this.put(name, Authorizations.combineKey(keys));
	}

	protected void setKeys(String name, String inheritedAuthority,
			Integer... keys) {

		this.put(name, Authorizations.combineKey(Stream
				.of(Stream.of(this.get(inheritedAuthority)), Stream.of(keys))
				.flatMap(x -> x).toArray(x -> new Integer[keys.length + 1])));
	}

}
