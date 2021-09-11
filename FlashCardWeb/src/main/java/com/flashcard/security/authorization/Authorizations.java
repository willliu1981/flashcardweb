package com.flashcard.security.authorization;

import org.junit.Test;

public class Authorizations {
	public static int combineKey(int... keys) {
		int cmbK = 0;
		for (int k : keys) {
			cmbK |= k;
		}
		return cmbK;
	}

	public static boolean hasKey(int source, int key) {
		return (source & key) == key;
	}


}
