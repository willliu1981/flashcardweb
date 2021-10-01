package test.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

@TestAnnotation
@TestAnnotation2
@TestAnnotation3
public class TestAnnotationDemo {

	public static void main(String[] args) throws ClassNotFoundException,
			IllegalArgumentException, IllegalAccessException {
		/*
		Class<?> testAnno = Class.forName("test.annotation.TestAnnotationDemo");
		Annotation[] annotations = testAnno.getAnnotations();
		for (Annotation annotation : annotations) {
			System.out.println(annotation.annotationType());
		}
		//*/

		TestAnnotationDemo demo = new TestAnnotationDemo();
		demo.doAnno();

		Book b = new Book();
		System.out.println(b);
		b.show();
	}

	public void doAnno() throws ClassNotFoundException,
			IllegalArgumentException, IllegalAccessException {
		Class<?> testAnno = Class.forName("test.annotation.Book");
		for (Field field : testAnno.getDeclaredFields()) {
			Annotation[] annotations = field.getDeclaredAnnotations();
			for (Annotation annotation : annotations) {
				if (annotation.annotationType() == MyAnnotation.class) {
					MyAnnotation anno = (MyAnnotation) annotation;
					System.out.println(anno);
					field.set(testAnno, anno.myType());
				}
			}

		}

	}

}
