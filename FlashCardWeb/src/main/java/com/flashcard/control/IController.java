package com.flashcard.control;

import java.util.Properties;

public interface IController {
	public void setSessions(Properties session);

	public void setTargets(Properties target);

	public void setNames(Properties name);

	public String session(String name);

	public String target(String name);

	public String name(String name);
}
