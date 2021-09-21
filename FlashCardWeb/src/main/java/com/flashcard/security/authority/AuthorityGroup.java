package com.flashcard.security.authority;

import java.util.HashMap;
import java.util.Map;

import com.flashcard.security.authorization.Authorizations;

public class AuthorityGroup<T> {
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
		/*
		  String matchKey 來自於Authority,ex:AdminAuthority.USER
		  是AdminAuthorization 的複數keys 組合
		 */
		Authority<Integer> auth = groupMap.get(group).getK();

		return auth.hasKey(groupMap.get(group).getV(), matchKey);
	}

	public boolean hasKey(String group, Integer matchKey) {
		/*
		  Integer matchKey 來自於Authorization,ex:AdminAuthorization.CREATE_USER
		 */
		Authority<Integer> auth = groupMap.get(group).getK();

		return auth.hasKey(groupMap.get(group).getV(), matchKey);
	}

	public void setGroup(String groupName, Authority<T> authority, String ownKey) {
		this.groupMap.put(groupName,
				new Pair<Authority, String>(authority, ownKey));
	}

	public String getAuthorityName(String groupName) {
		return this.groupMap.get(groupName).getV();
	}

	public Authority<T> getAuthority(String groupName) {
		return this.groupMap.get(groupName).getK();
	}

}
