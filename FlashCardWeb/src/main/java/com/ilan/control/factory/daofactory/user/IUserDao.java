package com.ilan.control.factory.daofactory.user;


import com.ilan.control.factory.daofactory.IDao;
import com.ilan.model.user.User;

public interface IUserDao extends UserDaoExtension<User>,IDao<User> {

}
