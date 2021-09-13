package com.flashcard.security.authority;

import java.util.HashMap;
import java.util.Map;

import com.flashcard.security.authorization.Authorizations;

public class AuthorityGroup {
	private static class Pair<K, V> {
		private K k;
		private V v;

		public Pair() {
		}

		public Pair(K k, V v) {
			this.k = k;
			this.v = v;
		}

		public K getK() {
			return k;
		}

		public void K(K k) {
			this.k = k;
		}

		public V getV() {
			return v;
		}

		public void setV(V v) {
			this.v = v;
		}
	}

	private Map<String, Pair<Authority, String>> groupMap = new HashMap<>();

	public boolean hasKey(String group, String matchKey) {
		Authority auth = groupMap.get(group).getK();
		return Authorizations.hasKey(
				auth.getAuthorityKey(groupMap.get(group).getV()),
				auth.getAuthorityKey(matchKey));
	}

	public void setGroup(String groupName, Authority authority, String ownKey) {
		this.groupMap.put(groupName, new Pair<Authority, String>(authority, ownKey));
	}
}
