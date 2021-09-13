package com.flashcard.security.authority;

import com.flashcard.factory.BeanFactory;

public class AuthorityFactory {
	private static AuthorityFactory factory = BeanFactory
			.getBean("authorityFactory", AuthorityFactory.class);
	private AuthorityGroup group;
	private IAuthorityConverter converter;

	public void setConverter(IAuthorityConverter converter) {
		this.converter = converter;
	}

	public static AuthorityGroup createAuthorityGroup(String userAuthority) {
		return factory.converter.convertToAuthority(userAuthority);
	}

	public static boolean hasKey(String authority, String group, String matchKey) {
		return createAuthorityGroup(authority).hasKey(group, matchKey);
	}

}
