package com.flashcard.security.authority;

public class AuthorityConverter implements IAuthorityConverter {
	private static Authority adminAuthority;
	private static Authority userAuthority;
	public static String USER = "user";
	public  static String ADMIN = "admin";

	@Override
	public AuthorityGroup convertToAuthority(String authority) {

		String[] auths = authority.split(",");

		AuthorityGroup group = new AuthorityGroup();
		group.setGroup(USER, userAuthority, auths[0]);
		group.setGroup(ADMIN, adminAuthority, auths[1]);

		return group;
	}

	public void setAdminAuthority(Authority adminAuthority) {
		this.adminAuthority = adminAuthority;
	}

	public void setUserAuthority(Authority userAuthority) {
		this.userAuthority = userAuthority;
	}

	public static void setGroupNameUser(String nameUser) {
		AuthorityConverter.USER = nameUser;
	}

	public static void setGroupNameAdmin(String nameAdmin) {
		AuthorityConverter.ADMIN = nameAdmin;
	}


	
	

}
