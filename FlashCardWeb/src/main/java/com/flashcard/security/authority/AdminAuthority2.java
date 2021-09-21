package com.flashcard.security.authority;

import java.util.stream.Stream;

import static com.flashcard.security.authority.AdminAuthority2.Type.*;
import com.flashcard.security.authorization.AdminAuthorization2;
import com.flashcard.security.authorization.Authorization;

public class AdminAuthority2 extends Authority<String> {
	private static String separator;

	public enum Type {
		USER, READER, EDITOR, ADMIN
		/*
		"USER";// 一般:(限會員所屬) 建立帳號、修改資料、檢視資料
		"READER";// 檢視管理員:USER 所有權限、讀取會員資料
		"EDITOR";// 編輯管理員:READER 所有權限、修改會員資料
		 "ADMIN";// 最高管理員:EDITOR 所有權限、刪除會員資料
		//*/
	}

	public void setAuthorizationConfig(Authorization authorization) {
	}

	@Override
	protected void setConfig() {
		// *
		this.setKeys(USER, AdminAuthorization2.CREATE_USER,
				AdminAuthorization2.MODIFY_USER, AdminAuthorization2.READ_USER);
		this.setKeys(READER, USER, AdminAuthorization2.READ_MEMBER_USER);
		this.setKeys(EDITOR, READER, AdminAuthorization2.MODIFY_MEMBER_USER);
		this.setKeys(ADMIN, EDITOR, AdminAuthorization2.DELETE_MEMBER_USER);
		// */

	}

	@Override
	public String getKey(String authName) {
		return this.get(authName);
	}

	public String getAuthorityKey(Type authName) {
		return this.get(authName.toString());
	}

	protected void setKeys(String name, String... keys) {
		this.put(name,
				Stream.of(keys).reduce((x, y) -> x + separator + y).orElse(""));
	}

	protected void setKeys(String name, String inheritedAuthority,
			String... keys) {
		this.put(name, Stream.of(keys).reduce(this.get(inheritedAuthority),
				(x, y) -> x + separator + y));
	}

	protected void setKeys(Type name, String... keys) {
		this.put(name.toString(),
				Stream.of(keys).reduce((x, y) -> x + separator + y).orElse(""));
	}

	protected void setKeys(Type name, Type inheritedAuthority, String... keys) {
		this.put(name.toString(),
				Stream.of(keys).reduce(this.get(inheritedAuthority.toString()),
						(x, y) -> x + separator + y));
	}

	public static void setSeparator(String separator) {
		AdminAuthority2.separator = separator;
	}

	@Override
	public boolean hasKey(String authorityName, String matchKey) {
		return this.getKey(authorityName).contains(matchKey) ;
	}

}
