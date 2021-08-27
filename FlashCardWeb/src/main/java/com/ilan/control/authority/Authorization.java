package com.ilan.control.authority;

import org.junit.Test;

public class Authorization {

	public  enum Member implements EnumValue {
		CREATECARD, READCARD, EDITCARD, DELETECARD;

		public int getValue() {
			return static_getValue(this.ordinal());
		}
	}

	public  enum Administrator implements EnumValue  {
		CREATEWORD, READWORD, EDITWORD, DELETEWORD, CREATEMEMBERCARD, READMEMBERCARD,
		EDITMEMBERCARD, DELETEMEMBERCARD;

		public int getValue() {
			return static_getValue(this.ordinal());
		}
	}

	private static int static_getValue(int ordinal) {
		return (int) Math.pow(2, ordinal);
	}
	
	

	@Test
	public void test() {
		// System.out.println("xx");
		// *
		Member m1 = Member.CREATECARD;
		Member m2 = Member.DELETECARD;
		System.out.println("" + (m1.getValue()));
		System.out.println("" + (m2.getValue()));
		// */
	}

}
