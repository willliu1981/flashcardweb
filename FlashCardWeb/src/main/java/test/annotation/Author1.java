package test.annotation;

public class Author1 extends Author {
	@AnnoAuthorName
	private String name;
	Integer age;

	@Override
	public String toString() {
		return String.format("author name=%s , write age=%d\n", this.name, this.age);
	}

}
