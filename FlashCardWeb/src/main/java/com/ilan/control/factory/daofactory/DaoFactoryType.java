package com.ilan.control.factory.daofactory;

import com.ilan.control.factory.daofactory.user.IUserDao;
import com.ilan.control.factory.daofactory.user.IUserdataDao;
import com.ilan.control.factory.type.IFactoryType;

public enum DaoFactoryType implements IFactoryType<IDao> {
	USERDAO("userDao", IUserDao.class), USERDATADAO("userdataDao", IUserdataDao.class);

	private String id;
	private Class<? extends IDao> type;

	private DaoFactoryType(String id, Class<? extends IDao> classType) {
		this.id = id;
		this.type = classType;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public Class<? extends IDao> getClassType() {
		return this.type;
	}

}
