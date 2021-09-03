package com.ilan.control.factory;

import org.springframework.context.ApplicationContext;

import com.ilan.control.config.Config;

public interface IFactory {
	public ApplicationContext getApplicationContext();
}
