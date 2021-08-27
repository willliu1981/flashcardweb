package com.ilan.control.authority;

import java.util.stream.Stream;

import org.junit.Test;

import com.ilan.control.authority.Authorization.Administrator;
import com.ilan.control.authority.Authorization.Member;

public class Authorites {
	private static final String AuthorityStrSplitSymbol = ":";

	private static boolean hasAuthorization(int authority, int... authorizations) {
		int as = addAuthorization(authorizations);
		return (authority & as) == as;
	}

	public static boolean hasAuthorization(int authority,
			AuthorizationEnumValue... authorizations) {
		return hasAuthorization(authority, convertToArrInt(authorizations));
	}

	private static int addAuthorization(int... authorizations) {
		int add = 0;
		for (int a : authorizations) {
			add |= a;
		}
		return add;
	}

	public static int addAuthorization(AuthorizationEnumValue... authorizations) {
		return addAuthorization(convertToArrInt(authorizations));
	}

	private static int[] convertToArrInt(AuthorizationEnumValue... authorizations) {
		return Stream.of(authorizations).mapToInt(AuthorizationEnumValue::getValue).toArray();
	}

	public static String toString(Authority authority) {
		return String.format("%s:%s", authority.getAuthority_member(),
				authority.getAuthority_admin());
	}

	public static Authority toAuthority(String authorityStr) {
		Authority authority = new Authority();
		try {
			String[] splitStr = authorityStr.split(AuthorityStrSplitSymbol);
			authority.setAuthority_member(Integer.parseInt(splitStr[0]));
			authority.setAuthority_admin(Integer.parseInt(splitStr[1]));
		} catch (Exception e) {

		}
		return authority;
	}

	public static Authority getDefaultAuthority() {
		Authority auth = new Authority();
		auth.setAuthority_member(Authorites.addAuthorization(Member.CREATECARD, Member.READCARD,
				Member.EDITCARD, Member.DELETECARD));
		return auth;
	}

	@Test
	public void test() {
		Member m1 = Authorization.Member.CREATECARD;
		Member m2 = Authorization.Member.EDITCARD;
		Member m3 = Authorization.Member.DELETECARD;

		int authority_m = Authorites.addAuthorization(m1, m2,m1);
		System.out.println("" + authority_m);
		System.out.println("" + Authorites.hasAuthorization(authority_m, m2));

		Administrator ma = Authorization.Administrator.CREATEMEMBERCARD;
		Administrator mb = Authorization.Administrator.DELETEWORD;

		int authority_ad = Authorites.addAuthorization(ma, mb);

		Authority authority = new Authority();
		authority.setAuthority_member(authority_m);
		authority.setAuthority_admin(authority_ad);

		System.out.println("to s **" + Authorites.toString(authority));

		Authority newAuthority = Authorites.toAuthority("5:24");
		System.out.println("to auth **" + newAuthority.getAuthority_member() + " and "
				+ newAuthority.getAuthority_admin());

	}
}
