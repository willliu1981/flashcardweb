package com.flashcard.security.authorization;

import org.junit.Test;

public class AdminAuthorization extends Authorization {
	private static KeyPointer keyPtr = new KeyPointer();
	public final static int CREATE_USER = autoKey(keyPtr);
	public final static int MODIFY_USER = autoKey(keyPtr);
	public final static int READ_USER = autoKey(keyPtr);
	public final static int READ_MEMBER_USER = autoKey(keyPtr);
	public final static int MODIFY_MEMBER_USER = autoKey(keyPtr);
	public final static int DELETE_MEMBER_USER = autoKey(keyPtr);

	@Test
	public void test() {
		System.out.println("" + READ_USER);
	}

}
