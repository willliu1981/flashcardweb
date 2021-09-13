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

	private Map<String, Pair<Authority, Integer>> groupMap = new HashMap<>();

	public boolean hasKey(String group, String key) {
		return Authorizations.hasKey(groupMap.get(group).getV(),
				groupMap.get(group).getK().getAuthorityKey(key));
	}

	public void setGroup(String authName, Authority auth, Integer key) {
		this.groupMap.put(authName, new Pair<Authority, Integer>(auth, key));
	}
}
