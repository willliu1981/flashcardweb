package gameobjectimpl.tool;

import java.awt.Container;

import gameobjectimpl.gui.ParentContainer;

public class Frames {

	public static void setBoundsCenterToParentContainer(
			ParentContainer parentContainer, Container target, int targetWidth,
			int targetHeight) {
		target.setBounds(
				(parentContainer.getWidth() - targetWidth) / 2 + parentContainer.getX(),
				(parentContainer.getHeight() - targetHeight) / 2
						+ parentContainer.getY(),
				targetWidth, targetHeight);
	}
}
