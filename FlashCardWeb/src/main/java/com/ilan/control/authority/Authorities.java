package com.ilan.control.authority;

import java.util.stream.Stream;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import com.ilan.control.authority.Authorization.Administrator;
import com.ilan.control.authority.Authorization.Member;
import com.ilan.control.authority.convert.ConvertAuthority;

public class Authorities {
	private static ConvertAuthority authorityConverter;

	static {
		try {
			authorityConverter = (ConvertAuthority) new InitialContext()
					.lookup("java:comp/env/authority/ConvertAuthority");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	private static boolean hasAuthorization(int authority, int... authorizations) {
		int as = addAuthorization(authorizations);
		return (authority & as) == as;
	}

	public static boolean hasAuthorization(int authority,
			AuthorizationEnumValue... authorizations) {
		return hasAuthorization(authority, convertToArrInt(authorizations));
	}

	public static boolean hasAuthorization(IAuthority user,
			AuthorizationEnumValue... authorizations) {

		return false;
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
		return authorityConverter.toString(authority);
	}

	public static Authority toAuthority(String authorityStr) {
		return authorityConverter.toAuthority(authorityStr);
	}

	public static Authority getDefaultAuthority() {
		return authorityConverter.getDefaultAuthority();
	}

	@Test
	public void test() {
		Member m1 = Authorization.Member.CREATECARD;
		Member m2 = Authorization.Member.EDITCARD;
		Member m3 = Authorization.Member.DELETECARD;

		int authority_m = Authorities.addAuthorization(m1, m2, m1);
		System.out.println("" + authority_m);
		System.out.println("" + Authorities.hasAuthorization(authority_m, m2));

		Administrator ma = Authorization.Administrator.CREATEMEMBERCARD;
		Administrator mb = Authorization.Administrator.DELETEWORD;

		int authority_ad = Authorities.addAuthorization(ma, mb);

		Authority authority = new Authority();
		authority.setAuthority_member(authority_m);
		authority.setAuthority_admin(authority_ad);

		System.out.println("to s **" + Authorities.toString(authority));

		Authority newAuthority = Authorities.toAuthority("5:24");
		System.out.println("to auth **" + newAuthority.getAuthority_member() + " and "
				+ newAuthority.getAuthority_admin());

	}
}
