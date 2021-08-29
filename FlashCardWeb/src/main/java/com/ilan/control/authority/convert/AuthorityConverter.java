package com.ilan.control.authority.convert;

import com.ilan.control.authority.Authorities;
import com.ilan.control.authority.Authority;
import com.ilan.control.authority.Authorization.Member;

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
		try {
			String[] splitStr = authorityStr.split(AuthorityStrSplitSymbol);
			authority.setAuthority_member(Integer.parseInt(splitStr[0]));
			authority.setAuthority_admin(Integer.parseInt(splitStr[1]));
		} catch (Exception e) {

		}
		return authority;
	}

	@Override
	public Authority getDefaultAuthority() {
		Authority auth = new Authority();
		auth.setAuthority_member(Authorities.addAuthorization(Member.CREATECARD, Member.READCARD,
				Member.EDITCARD, Member.DELETECARD));
		System.out.println("xxx");
		return auth;
	}

}
