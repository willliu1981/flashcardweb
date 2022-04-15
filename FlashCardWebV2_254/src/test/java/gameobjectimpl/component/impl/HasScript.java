package gameobjectimpl.component.impl;

import java.util.List;

import gameobjectimpl.control.ScriptI;

public interface HasScript {
	void addScript(ScriptI script);
	List<ScriptI> getScripts();
}
