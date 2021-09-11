package com.flashcard.security.authority;

public class UserAuthority extends Authority {
	private String READER;
	private String EDITOR;
	private String ADMIN;

	@Override
	protected void setConfig() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getAuthorityKey(String authName) {
		// TODO Auto-generated method stub
		return 0;
	}
}
