package com.ilan.control.authority.type;

import com.ilan.control.authority.AuthorizationEnumValue;

public enum Admin implements AuthorizationEnumValue {
	CREATEWORD, READWORD, EDITWORD, DELETEWORD, CREATEMEMBERCARD, READMEMBERCARD,
	EDITMEMBERCARD, DELETEMEMBERCARD;

	@Override
	public int getValue() {
		return AuthorizationEnumValue.static_getValue(this.ordinal());
	}
}