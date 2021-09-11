package com.flashcard.factory;

public interface IFactoryType<T> {
	 String getId();
	 Class<? extends T> getClassType();
}
