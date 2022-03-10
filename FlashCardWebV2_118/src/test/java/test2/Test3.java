package test2;

import java.util.List;

import idv.fc.dao.abstraction.Dao;

public class Test3 {

	public static void main(String[] args) {

	}

	static class A {

		private String msg;
		private String title;

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

	}

	static class B {
		private A a;
		private Dao dao;

		public B(A a) {
			this.a = a;
		}

		public String getMsg() {
			return a.getMsg();
		}

		public B setMsg(String msg) {
			a.setMsg(msg);
			return this;
		}

		public String getTitle() {
			return a.getTitle();
		}

		public void setTitle(String title) {
			a.setTitle(title);
		}

		public A getA() {
			return a;
		}

		public void setA(A a) {
			this.a = a;
		}

		public void create() {
			dao.create(a);
		}

		public void delete() {
			dao.delete(a);
		}

		public void update(Object id) {
			dao.update(a, id);
		}

		public Object queryById(Object id) {
			return dao.queryById(id);
		}

		public List queryAll() {
			return dao.queryAll();
		}


		
	

	}

}
