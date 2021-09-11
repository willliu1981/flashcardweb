package com.flashcard.security.authority;

public abstract class Authority {
	
	protected Authority() {
		setConfig();
	}
	
	abstract protected  void setConfig() ;
	abstract public  int getAuthorityKey(String authName) ;
	
}
