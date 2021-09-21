package com.flashcard.security.authorization;

public abstract class Authorization {
	static protected class KeyPointer{
		int var;
		
	}
	
	protected static int autoKey(KeyPointer obj) {
		return (int) Math.pow(2, obj.var++);
	}
	

	
	
}
