package com.flashcard.security.authority;

import java.util.Properties;

import com.flashcard.factory.BeanFactory;

public class AuthorityFactory {
	private static AuthorityFactory factory = BeanFactory
			.getBean("authorityFactory", AuthorityFactory.class);
	private AuthorityGroup group;
	private IAuthorityConverter converter;
	private static Properties groupName;

	public void setConverter(IAuthorityConverter converter) {
		this.converter = converter;
	}

	public static AuthorityGroup createAuthorityGroup(String userAuthority) {
		return factory.converter.convertToAuthority(userAuthority);
	}

	public static boolean key(String authority, String group, String matchKey) {
		/*
		  String authority 來自於 model 的 authotiry
		  其它類似method略
		 */
		return createAuthorityGroup(authority).hasKey(group, matchKey);
	}

	public static boolean key(String authority, String group,
			Integer matchKey) {
		return createAuthorityGroup(authority).hasKey(group, matchKey);
	}

	public static String getGroupDefinitionOfName(String name) {
		return groupName.getProperty(name);
	}

	public void setGroupNames(Properties groupName) {
		AuthorityFactory.groupName = groupName;
	}
	

	
}
