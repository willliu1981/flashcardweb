package com.flashcard.security.authority;

import java.util.stream.Stream;

import com.flashcard.security.authorization.AdminAuthorization;
import com.flashcard.security.authorization.Authorizations;

public class AdminAuthority extends Authority<Integer> {
	public static String USER = "USER";// 一般:(限會員所屬) 建立帳號、修改資料、檢視資料
	public static String READER = "READER";// 檢視管理員:USER 所有權限、讀取會員資料
	public static String EDITOR = "EDITOR";// 編輯管理員:READER 所有權限、修改會員資料
	public static String ADMIN = "ADMIN";// 最高管理員:EDITOR 所有權限、刪除會員資料

	// private static Map<String, Integer> keyMap = new HashMap<>();

	@Override
	protected void setConfig() {
		this.setKeys(USER, AdminAuthorization.CREATE_USER,
				AdminAuthorization.MODIFY_USER, AdminAuthorization.READ_USER);
		this.setKeys(READER, USER, AdminAuthorization.READ_MEMBER_USER);
		this.setKeys(EDITOR, READER, AdminAuthorization.MODIFY_MEMBER_USER);
		this.setKeys(ADMIN, EDITOR, AdminAuthorization.DELETE_MEMBER_USER);
	}

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

	@Override
	public boolean hasKey(String authorityName, Integer matchKey) {
		return Authorizations.hasKey(this.getKey(authorityName), matchKey);
	}

	@Override
	public boolean hasKey(String authorityName, String matchKey) {
		return Authorizations.hasKey(this.getKey(authorityName),
				this.getKey(matchKey));
	}

}
