package test.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import test.annotation.AnnoBookInfo.BookType;

@TestAnnotation
@TestAnnotation2
@TestAnnotation3
public class AnnotationDemo {
	@AnnoBookInfo(book = "test.annotation.Book1", name = "Java Web", bookType = BookType.JAVA)
	Book b;

	public static void main(String[] args) throws ClassNotFoundException,
			IllegalArgumentException, IllegalAccessException, InstantiationException {

		AnnotationDemo demo = new AnnotationDemo();
		AnnotationDemo.process(demo);

		demo.b.show();
	}

	public static void process(Object instance) throws ClassNotFoundException,
			IllegalArgumentException, IllegalAccessException, InstantiationException {

		for (Field fieldBook : instance.getClass().getDeclaredFields()) {
			if (fieldBook.isAnnotationPresent(AnnoBookInfo.class)) {
				AnnoBookInfo bookAnno = fieldBook.getAnnotation(AnnoBookInfo.class);
				fieldBook.setAccessible(true);
				Class<?> bookType = Class.forName(bookAnno.book());
				Book bookInstance = (Book) bookType.newInstance();
				fieldBook.set(instance, bookInstance);

				for (Field fieldInBook : bookType.getDeclaredFields()) {
					fieldInBook.setAccessible(true);

					if (fieldInBook.isAnnotationPresent(AnnoBookType.class)) {
						fieldInBook.set(bookInstance, bookAnno.bookType());
					} else if (fieldInBook.isAnnotationPresent(AnnoBookName.class)) {
						fieldInBook.set(bookInstance, bookAnno.name());
					} else if (fieldInBook.isAnnotationPresent(AnnoBookAuthor.class)) {
						AnnoBookAuthor authorAnno = fieldInBook
								.getAnnotation(AnnoBookAuthor.class);

						Class<?> authorType = Class.forName(authorAnno.author());
						Author authorInstance = (Author) authorType.newInstance();
						fieldInBook.set(bookInstance, authorInstance);

						for (Field fieldInAuthor : authorType.getDeclaredFields()) {
							fieldInAuthor.setAccessible(true);
							if (fieldInAuthor
									.isAnnotationPresent(AnnoAuthorName.class)) {
								fieldInAuthor.set(authorInstance, authorAnno.name());
							}
						}

					}

				}

			}
		}

	}

}
