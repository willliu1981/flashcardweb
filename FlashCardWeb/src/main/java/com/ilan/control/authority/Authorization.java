package com.ilan.control.authority;

public class Authorization {
	private String uid;
	private String userDisplayName;
	private String authMember;
	private String authAdmin;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUserDisplayName() {
		return userDisplayName;
	}

	public void setUserDisplayName(String userDisplayName) {
		this.userDisplayName = userDisplayName;
	}

	public String getAuthMember() {
		return authMember;
	}

	public void setAuthMember(String authMember) {
		this.authMember = authMember;
	}

	public String getAuthAdmin() {
		return authAdmin;
	}

	public void setAuthAdmin(String authAdmin) {
		this.authAdmin = authAdmin;
	}



}
