package com.flashcard.security.authority;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.flashcard.security.authorization.AdminAuthorization;
import com.flashcard.security.authorization.Authorizations;

public class AdminAuthority extends Authority {
	public static String USER = "USER";// 一般:(限會員所屬) 建立帳號、修改資料、檢視資料
	public static String EDITOR = "EDITOR";// 編輯管理員:USER 所有權限、修改會員資料
	public static String ADMIN = "ADMIN";// 最高管理員:EDITOR 所有權限、刪除會員資料

	public static Map<String, Integer> keyMap = new HashMap<>();

	@Override
	protected void setConfig() {
		keyMap.put(USER, Authorizations.combineKey(AdminAuthorization.CREATE_USER,
				AdminAuthorization.MODIFY_USER, AdminAuthorization.READ_USER));
		keyMap.put(EDITOR,
				Authorizations.combineKey(keyMap.get(USER), AdminAuthorization.MODIFY_MEMBER_USER));
		keyMap.put(ADMIN, Authorizations.combineKey(keyMap.get(EDITOR),
				AdminAuthorization.DELETE_MEMBER_USER));

	}

	@Test
	public void test() {
		setConfig();

		boolean r = Authorizations.hasKey(keyMap.get(ADMIN),
				AdminAuthorization.DELETE_MEMBER_USER);
		System.out.println("" + r);

	}

}
