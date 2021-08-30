package com.ilan.control.authority.convert;

import com.ilan.control.authority.Authority;
import com.ilan.control.authority.HasAuthority;
import com.ilan.control.authority.type.AuthorizationEnumValue;

public interface ConvertAuthority {
	String toString(Authority authority);

	Authority toAuthority(String authorityStr);

	Authority getDefaultAuthority();

	boolean hasAuthorization(HasAuthority user, AuthorizationEnumValue... authorizations);

}
