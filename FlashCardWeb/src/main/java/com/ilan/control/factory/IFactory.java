package com.ilan.control.factory;

import org.springframework.context.ApplicationContext;

import com.ilan.appinitialization.Config;

public interface IFactory {
	public ApplicationContext getApplicationContext();
}
