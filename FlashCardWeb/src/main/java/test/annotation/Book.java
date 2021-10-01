package test.annotation;

class Book {
	@MyAnnotation(myType = MyType.T1)
	public MyType type;

	public void show() {
		System.out.println("type=" + type);
	}

}