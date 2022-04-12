package gameobjectimpl.control;

import java.awt.Point;

import gameobjectimpl.component.GameObject;
import gameobjectimpl.config.Application;

public class ScriptFactory {

	public static <T> T getInputPlatform(GameObject controlledTtarget, Class<T> clazz) {
		InputPlatform inputPlatform = null;
		try {
			inputPlatform = (InputPlatform) clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		inputPlatform.setTarget(controlledTtarget);

		return (T) inputPlatform;
	}

}
