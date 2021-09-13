package com.flashcard.security.authority;

public abstract class AuthorityAdapter extends Authority {

	@Override
	public Integer getAuthorityKey(String authName) {
		return this.keyMap.get(authName);
	}

}
