package com.flashcard.security.authority;

public class UserAuthority extends AuthorityAdapter {
	private String READER;
	private String EDITOR;
	private String ADMIN;

	@Override
	protected void setConfig() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasKey(String authorityName, Integer matchKey) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasKey(String authorityName, String matchKey) {
		// TODO Auto-generated method stub
		return false;
	}


}
