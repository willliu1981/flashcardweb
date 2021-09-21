package com.flashcard.security.authorization;

import java.util.HashSet;
import java.util.Properties;

public class AdminAuthorization2 extends Authorization {
	public static String CREATE_USER;
	public static String MODIFY_USER;
	public static String READ_USER;
	public static String READ_MEMBER_USER;
	public static String MODIFY_MEMBER_USER;
	public static String DELETE_MEMBER_USER;

	private static Properties keys;

	public void setKeys(Properties keys) {
		AdminAuthorization2.keys = keys;
	}

	public String getKey(String name) {
		return keys.getProperty(name);
	}

	public void init() {
		CREATE_USER = keys.getProperty("create_user");
		MODIFY_USER = keys.getProperty("modify_user");
		READ_USER = keys.getProperty("read_user");
		READ_MEMBER_USER = keys.getProperty("read_member_user");
		MODIFY_MEMBER_USER = keys.getProperty("modify_member_user");
		DELETE_MEMBER_USER = keys.getProperty("delete_member_user");
	}

}
