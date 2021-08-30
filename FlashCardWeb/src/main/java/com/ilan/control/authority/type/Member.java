package com.ilan.control.authority.type;

import com.ilan.control.authority.AuthorizationEnumValue;

public enum Member implements AuthorizationEnumValue {
	CREATECARD, READCARD, EDITCARD, DELETECARD;

	@Override
	public int getValue() {
		return AuthorizationEnumValue.static_getValue(this.ordinal());
	}
}