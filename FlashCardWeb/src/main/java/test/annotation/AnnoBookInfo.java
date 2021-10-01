package test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnoBookInfo {

	BookType bookType();

	String name() default "null";

	String book();

	enum BookType {

		JAVA, CSHARP, PHP
	}

}
