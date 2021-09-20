package com.flashcard.control;

import java.util.Properties;

public interface ControllerAdapter extends IController {

	@Override
	default void setSessions(Properties session) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void setTargets(Properties target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default void setNames(Properties name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	default String session(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default String target(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	default String name(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
