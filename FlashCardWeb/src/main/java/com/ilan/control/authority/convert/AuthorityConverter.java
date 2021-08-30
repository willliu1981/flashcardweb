package com.ilan.control.authority.convert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.ilan.control.authority.Authorities;
import com.ilan.control.authority.Authority;
import com.ilan.control.authority.HasAuthority;
import com.ilan.control.authority.type.Admin;
import com.ilan.control.authority.type.AuthorizationEnumValue;
import com.ilan.control.authority.type.Member;
import com.ilan.model.user.User;

public class AuthorityConverter implements ConvertAuthority {
	private static final String AuthorityStrSplitSymbol = ":";

	@Override
	public String toString(Authority authority) {
		return String.format("%s:%s", authority.getAuthority_member(),
				authority.getAuthority_admin());
	}

	@Override
	public Authority toAuthority(String authorityStr) {
		Authority authority = new Authority();
		if (authorityStr == null) {
			authorityStr = "";
		}
		try {
			String[] splitStr = authorityStr.split(AuthorityStrSplitSymbol);
			authority.setAuthority_member(Integer.parseInt(splitStr[0]));
			authority.setAuthority_admin(Integer.parseInt(splitStr[1]));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return authority;
	}

	@Override
	public Authority getDefaultAuthority() {
		Authority auth = new Authority();
		auth.setAuthority_member(Authorities.combineAuthorization(Member.CREATECARD, Member.READCARD,
				Member.EDITCARD, Member.DELETECARD));
		return auth;
	}

	@Override
	public boolean hasAuthorization(HasAuthority user, AuthorizationEnumValue... authorizations) {
		Map<Object, List<AuthorizationEnumValue>> map = Stream.of(authorizations)
				.collect(Collectors.groupingBy(x -> x.getClass().getName()));
		Authority auth = Authorities.toAuthority(user.getAuthority());

		boolean mflag = Authorities.hasAuthorization(auth.getAuthority_member(),
				map.get(Member.class.getName()));
		boolean aflag = Authorities.hasAuthorization(auth.getAuthority_admin(),
				map.get(Admin.class.getName()));

		return mflag && aflag;
	}

	@Test
	public void test() {
		User user = new User();
		Authority auth = new Authority();
		auth.setAuthority_member(Authorities.combineAuthorization(Member.CREATECARD, Member.EDITCARD));
		auth.setAuthority_admin(Authorities.combineAuthorization(Admin.CREATEWORD,
				Admin.DELETEMEMBERCARD, Admin.READMEMBERCARD));

		String authStr = null;
		System.out.println("** " + (authStr = Authorities.toString(auth)));

		user.setAuthority(authStr);

		hasAuthorization(user, Member.CREATECARD, Member.EDITCARD, Admin.CREATEWORD,
				Admin.DELETEMEMBERCARD, Admin.READMEMBERCARD);
	}

}
