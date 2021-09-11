package com.flashcard.factory.dao;

import com.flashcard.factory.IFactoryType;
import com.flashcard.factory.dao.user.IUserDao;
import com.flashcard.factory.dao.user.IUserdataDao;

public enum DaoFactoryType implements IFactoryType<IDao> {
	//USERDAO("userDao", IUserDao.class), USERDATADAO("userdataDao", IUserdataDao.class);
	USERDAO("userDao"), USERDATADAO("userdataDao");

	private String id;
	private Class<? extends IDao> type;

	private DaoFactoryType(String id, Class<? extends IDao> classType) {
		this.id = id;
		this.type = classType;
	}
	private DaoFactoryType(String id) {
		this.id = id;
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
