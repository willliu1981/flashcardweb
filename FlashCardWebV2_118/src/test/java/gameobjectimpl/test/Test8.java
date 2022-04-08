package gameobjectimpl.test;

import idv.tool.Debug;

public class Test8 {

	static class BookI {

	}

	public static void main(String[] args)
			throws InstantiationException, IllegalAccessException {
		BookI newInstance = BookI.class.newInstance();

		Debug.test(newInstance);
	}

}
