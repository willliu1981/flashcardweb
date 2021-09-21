package com.flashcard.security.authority;

public interface IAuthorityConverter<T> {
	AuthorityGroup<T> convertToAuthority(String authority);
}
