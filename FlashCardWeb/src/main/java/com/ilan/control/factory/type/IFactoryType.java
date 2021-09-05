package com.ilan.control.factory.type;

public interface IFactoryType<T> {
	 String getId();
	 Class<? extends T> getClassType();
}
