package com.flashcard.tool;

import org.junit.Test;

public class Pages {

	public static boolean isLast(int pageCount, int page, int maxPage) {
		int p = (int) Math.ceil((double) pageCount / maxPage);
		return page == p;
	}

	@Test
	public void test() {
		System.out.println("" + isLast(21, 1, 5));
		System.out.println("" + Math.ceil(23.0 / 5));
	}
}
