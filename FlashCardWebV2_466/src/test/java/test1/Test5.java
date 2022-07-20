package test1;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test5 {
	Logger logger = LoggerFactory.getLogger(Test.class);

	static class Person {
		private NameWrap wrap = new NameWrap();
		private Info info;

		public Person() {
			info = new Info(wrap);
		
		}

		public void setName(String name) {
			wrap.setName(name);
		}

		@Override
		public String toString() {
			return "Person [info=" + info + "]";
		}
	}

	static class Info {
		private NameWrap wrap;

		public Info(NameWrap wrap) {
			this.wrap = wrap;
		}

		public String getUserName() {
			return this.wrap.getName();
		}

		@Override
		public String toString() {
			return "Info [getUserName()=" + getUserName() + "]";
		}

	}

	static class NameWrap {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}

	@Test
	public void test1() {
		Person p = new Person();
		p.setName("David");

		System.out.println(p);
	}
}
