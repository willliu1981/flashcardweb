package test1;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test4 {
	Logger logger = LoggerFactory.getLogger(Test.class);

	static class Person {
		private String name;
		private Info info;

		public Person() {
			info = new Info(name);
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", info=" + info + "]";
		}
	}

	static class Info {
		private String userName;
		private String content;

		public Info(String userName) {
			this.userName = userName;
		}

		@Override
		public String toString() {
			return "Info [userName=" + userName + ", content=" + content + "]";
		}
	}

	@Test
	public void test1() {
		Person p = new Person();
		p.setName("David");

		System.out.println(p);
	}
}
