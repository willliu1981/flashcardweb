package com.ilan.control.dao.factory.user;

import com.ilan.control.dao.Dao;
import com.ilan.control.dao.user.UserDao;
import com.ilan.model.user.User;

public abstract class  AbstractUserDao implements Dao<User>, UserDaoExtension<User>  {

}
