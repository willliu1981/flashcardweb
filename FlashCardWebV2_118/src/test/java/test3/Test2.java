package test3;

import idv.fc.test.Faker;
import idv.fc.tool.Debug;
import idv.fc.tool.SpringUtil;

public class Test2 {

	public static void main(String[] args) {
		Faker faker=(Faker) SpringUtil.getBean("NewUserFaker");

	}
	


}
