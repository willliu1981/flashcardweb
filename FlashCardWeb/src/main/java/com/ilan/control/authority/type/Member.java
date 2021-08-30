package com.ilan.control.authority.type;

public enum Member implements AuthorizationEnumValue {
	CREATECARD, READCARD, EDITCARD, DELETECARD;

	@Override
	public int getValue() {
		return AuthorizationEnumValue.static_getValue(this.ordinal());
	}
}