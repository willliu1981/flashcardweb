package com.ilan.control.authority;

public interface AuthorizationEnumValue {
	int getValue();
	
	static int static_getValue(int ordinal) {
		return (int) Math.pow(2, ordinal);
	}
}
