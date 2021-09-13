package com.flashcard.security.authority;

public class AuthorityConverter implements IAuthorityConverter {
	private static Authority adminAuthority;
	private static Authority userAuthority;
	private static String nameUser="user";
	private static String nameAdmin="admin";

	@Override
	public AuthorityGroup convertToAuthority(String authority) {

		String[] auths = authority.split(",");

		AuthorityGroup group = new AuthorityGroup();
		group.setGroup(nameUser, userAuthority,
				userAuthority.getAuthorityKey(auths[0]));
		group.setGroup(nameAdmin, adminAuthority,
				adminAuthority.getAuthorityKey(auths[1]));

		return group;
	}

	public void setAdminAuthority(Authority adminAuthority) {
		this.adminAuthority = adminAuthority;
	}

	public void setUserAuthority(Authority userAuthority) {
		this.userAuthority = userAuthority;
	}

	public static void setNameUser(String nameUser) {
		AuthorityConverter.nameUser = nameUser;
	}

	public static void setNameAdmin(String nameAdmin) {
		AuthorityConverter.nameAdmin = nameAdmin;
	}

}
