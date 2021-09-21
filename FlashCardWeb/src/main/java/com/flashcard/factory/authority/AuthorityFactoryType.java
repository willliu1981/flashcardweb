package com.flashcard.factory.authority;

import com.flashcard.factory.IFactoryType;
import com.flashcard.security.authority.AuthorityGroup;

public enum AuthorityFactoryType implements IFactoryType<AuthorityGroup> {
	USERDAO("userDao"), USERDATADAO("userdataDao");

	private String id;
	private Class<? extends AuthorityGroup> type;

	private AuthorityFactoryType(String id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public Class<? extends AuthorityGroup> getClassType() {
		return this.type;
	}

}
