package com.flashcard.security.authorization;

import org.junit.Test;

public class Authorizations {
	public static Integer combineKey(Integer... keys) {
		int cmbK = 0;
		for (Integer k : keys) {
			cmbK |= k;
		}
		return cmbK;
	}

	public static boolean hasKey(Integer source, Integer key) {
		return (source & key) == key;
	}


}
