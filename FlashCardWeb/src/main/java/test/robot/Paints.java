package test.robot;

import java.awt.Rectangle;

public class Paints {
	
	public static void Paint(Component comp) {
		
		for(Component c:comp.getAttachs()) {
			System.out.println("xxx "+c.getName());
			Rectangle rect=ComponentFactory.getRect(c);
			System.out.printf("paints ** %s ,(%s)\n",c.getName(),rect);
		}
		
		
	}
	
	
}
