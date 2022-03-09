package test2;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Deque;
import java.util.LinkedList;

public class Test2 {

	public static void main(String[] args) {
		C c = new C();
		B b = (B) c;
		b.m();
	}

	static class A<T> {

	}

	static class B<T> extends A<T> {

		public void m() {
			ParameterizedType t = (ParameterizedType) this.getClass()
					.getGenericSuperclass();
			Type[] ts = t.getActualTypeArguments();

			Class clazz = (Class) ts[0];

			Deque<String> names = new LinkedList<>();

			do {
				names.offerFirst(clazz.getSimpleName());
				if (names.size() > 2) {
					names.pollLast();
				}

			} while ((clazz = clazz.getSuperclass()) != null);

			if (names.peekLast().equalsIgnoreCase("object")) {
				System.out.println("ss : " + names.peekFirst());
			} else {
				System.out.println("ss : " + names.peekLast());
			}

		}
	}

	static class C extends B<Small3Car> {

	}

	class Car {

	}

	class LittleCar extends Car {

	}

	class SmallCar extends LittleCar {

	}

	class Small2Car extends SmallCar {

	}

	class Small3Car extends Small2Car {

	}

}
