package com.ilan.control.authority;

import java.util.List;
import java.util.stream.Stream;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.junit.Test;

import com.ilan.control.authority.Authorization.Admin;
import com.ilan.control.authority.Authorization.Member;
import com.ilan.control.authority.convert.AuthorityConverter;
import com.ilan.control.authority.convert.ConvertAuthority;

public class Authorities {
	private static ConvertAuthority authorityConverter;

	static {
		// *
		try {
			authorityConverter = (ConvertAuthority) new InitialContext()
					.lookup("java:comp/env/authority/ConvertAuthority");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		// */
		// authorityConverter = new AuthorityConverter();// just for test
	}

	private static boolean hasAuthorization(int authority, int... authorizations) {
		int as = combineAuthorization(authorizations);
		return (authority & as) == as;
	}

	public static boolean hasAuthorization(int authority,
			AuthorizationEnumValue... authorizations) {
		return hasAuthorization(authority, convertToArrInt(authorizations));
	}

	public static boolean hasAuthorization(int authority,
			List<AuthorizationEnumValue> authorizations) {
		AuthorizationEnumValue[] arrAuthorizations = null;
		if (authorizations != null) {
			arrAuthorizations = new AuthorizationEnumValue[authorizations.size()];
			authorizations.toArray(arrAuthorizations);
		}

		return hasAuthorization(authority, arrAuthorizations);
	}

	public static boolean hasAuthorization(HasAuthority user,
			AuthorizationEnumValue... authorizations) {
		return authorityConverter.hasAuthorization(user, authorizations);
	}

	private static int combineAuthorization(int... authorizations) {
		if (authorizations == null) {
			return 0;
		}
		int add = 0;
		for (int a : authorizations) {
			add |= a;
		}
		return add;
	}

	public static int addAuthorization(AuthorizationEnumValue... authorizations) {
		return combineAuthorization(convertToArrInt(authorizations));
	}

	private static int[] convertToArrInt(AuthorizationEnumValue... authorizations) {
		int[] arrAuthValue = null;
		if (authorizations != null) {
			arrAuthValue = Stream.of(authorizations).mapToInt(AuthorizationEnumValue::getValue)
					.toArray();
		}
		return arrAuthValue;
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

	public static String getMsg(AuthorizationEnumValue msg  ) {
		return "hellooooo " + msg;
	}

	// @Test
	public void test() {
		Member m1 = Authorization.Member.CREATECARD;
		Member m2 = Authorization.Member.EDITCARD;
		Member m3 = Authorization.Member.DELETECARD;

		int authority_m = Authorities.addAuthorization(m1, m2, m1);
		System.out.println("" + authority_m);
		System.out.println("" + Authorities.hasAuthorization(authority_m, m2));

		Admin ma = Authorization.Admin.CREATEMEMBERCARD;
		Admin mb = Authorization.Admin.DELETEWORD;

		int authority_ad = Authorities.addAuthorization(ma, mb);

		Authority authority = new Authority();
		authority.setAuthority_member(authority_m);
		authority.setAuthority_admin(authority_ad);

		System.out.println("to s **" + Authorities.toString(authority));

		Authority newAuthority = Authorities.toAuthority("5:24");
		System.out.println("to auth **" + newAuthority.getAuthority_member() + " and "
				+ newAuthority.getAuthority_admin());

	}

	@Test
	public void test2() {
		int[] iis = convertToArrInt(null);
		System.out.println("xxx " + iis);
	}
}
