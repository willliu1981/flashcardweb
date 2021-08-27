package com.ilan.control.authority;

import java.util.stream.Stream;

import org.junit.Test;

import com.ilan.control.authority.Authorization.Member;

public class Authorites {

	public static boolean hasAuthorization(int authority, int... authorizations) {
		int as = addAuthorization(authorizations);
		return (authority & as) == as;
	}

	public static boolean hasAuthorization(int authority, EnumValue... authorizations) {
		return hasAuthorization(authority, convertToArrInt(authorizations));
	}

	public static int addAuthorization(int... authorizations) {
		int add = 0;
		for (int a : authorizations) {
			add |= a;
		}
		return add;
	}

	public static int addAuthorization(EnumValue... authorizations) {
		return addAuthorization(convertToArrInt(authorizations));
	}

	private static int[] convertToArrInt(EnumValue... authorizations) {
		return Stream.of(authorizations).mapToInt(EnumValue::getValue).toArray();
	}

	@Test
	public void test() {
		Member m1 = Authorization.Member.CREATECARD;
		Member m2 = Authorization.Member.EDITCARD;
		Member m3 = Authorization.Member.DELETECARD;

		int authority = Authorites.addAuthorization(m1, m2);

		System.out.println("" + authority);
		System.out.println("" + Authorites.hasAuthorization(authority,m2));

	}
}
