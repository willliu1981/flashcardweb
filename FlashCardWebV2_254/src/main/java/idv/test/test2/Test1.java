package idv.test.test2;

import idv.fc.dao.UserCommonDao;
import idv.tool.Debug;
import idv.tool.spring.SpringUtil;

public class Test1 {

	public static void main(String[] args) {
		UserCommonDao dao = SpringUtil.getBean("UserDao", UserCommonDao.class);
		Debug.test("t1", dao);
	}

}
