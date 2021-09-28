package test.injection;

import java.util.stream.Stream;

import test.injection.MenuDocument.Document;

public class Menu {
	int age;
	MenuDocument doc = new MenuDocument();

	public String createMenu(int age) {
		String output = null;

		try {
			Document docx = doc.getDocument(age);
			output = docx.getName() + "的" + (String) docx.getObject();
		} catch (NullPointerException e) {
			output = "" + age;
		}

		return output;
	}

	public MenuDocument getDoc() {
		return doc;
	}

}
