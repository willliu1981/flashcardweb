package gameobjectimpl.gui.test;

import gameobjectimpl.animator.AnimatorBuilder;
import gameobjectimpl.component.impl.Person;
import gameobjectimpl.config.Application;
import idv.tool.Debug;
import idv.tool.spring.MySpringUtil;

public class Test1 {

	static class Book {
		String name;

		@Override
		public String toString() {
			return "Book [name=" + name + "]";
		}

	}

	static class EBook extends Book {
		int screensize;

		@Override
		public String toString() {
			return "EBook [screensize=" + screensize + ", toString()="
					+ super.toString() + "]";
		}

	}

	public static void main(String[] args) {

		Book b = new EBook();
		Debug.test(b);

	}

}
