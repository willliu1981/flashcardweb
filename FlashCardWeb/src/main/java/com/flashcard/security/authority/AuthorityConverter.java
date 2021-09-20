package com.flashcard.security.authority;

public class AuthorityConverter implements IAuthorityConverter {

	private static Authority adminAuthority;
	private static Authority userAuthority;

	@Override
	public AuthorityGroup convertToAuthority(String authority) {

		String[] auths = authority.split(",");

		AuthorityGroup group = new AuthorityGroup();
		group.setGroup(AuthorityFactory.getGroupName("user"), userAuthority,
				auths[0]);
		group.setGroup(AuthorityFactory.getGroupName("admin"), adminAuthority,
				auths[1]);

		return group;
	}

	public void setAdminAuthority(Authority adminAuthority) {
		this.adminAuthority = adminAuthority;
	}

	public void setUserAuthority(Authority userAuthority) {
		this.userAuthority = userAuthority;
	}

}
