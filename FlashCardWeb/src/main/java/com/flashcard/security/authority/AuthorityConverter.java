package com.flashcard.security.authority;

public class AuthorityConverter implements IAuthorityConverter {
	private static Authority<?> adminAuthority;
	private static Authority<?> userAuthority;
	private static String separator;

	@Override
	public AuthorityGroup convertToAuthority(String authority) {

		String[] auths = authority.split(separator);

		AuthorityGroup group = new AuthorityGroup();
		group.setGroup(AuthorityFactory.getGroupDefinitionOfName("user"), userAuthority,
				auths[0]);
		group.setGroup(AuthorityFactory.getGroupDefinitionOfName("admin"), adminAuthority,
				auths[1]);

		return group;
	}

	public void setAdminAuthority(Authority<?> adminAuthority) {
		this.adminAuthority = adminAuthority;
	}

	public void setUserAuthority(Authority<?> userAuthority) {
		this.userAuthority = userAuthority;
	}

	public static void setSeparator(String separator) {
		AuthorityConverter.separator = separator;
	}

}
