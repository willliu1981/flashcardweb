package com.ilan.control.dao.factory.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.ilan.control.connection.MyConnection;
import com.ilan.control.dao.Dao;
import com.ilan.control.dao.factory.AbstractDaoFactory;
import com.ilan.model.user.User;

public class UserDaoFactory extends AbstractDaoFactory {
	private static UserDaoFactory factory;
	private Class<?> clazz;

	public UserDaoFactory() {
	}

	@Override
	public void setDaoType(String klazz) {
		if (clazz == null) {
			try {
				clazz = Class.forName(klazz);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public static UserDaoFactory getInstance() {
		if (factory == null) {
			try {
				factory = (UserDaoFactory) new InitialContext()
						.lookup("java:comp/env/daoFactory/UserDaoFactory");
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}
		return factory;
	}

	@Override
	public Dao<?> getDefaultDao() {
		try {
			return (Dao<?>) clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean identifyUser(String username, String password) {
		User user;
		try {
			user = (User) ((UserDaoExtension<?>) clazz.newInstance())
					.identifyUser(username, password);
			if (user != null) {
				return true;
			} else {
				return false;
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public User findUserByUsername(String username) {
		Connection conn = MyConnection.getConnection();

		String sql = "select * from user where username=?";
		User r = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				r = new User();
				r.setU_id(rs.getString("u_id"));
				r.setDisplayName(rs.getString("displayname"));
				r.setUsername(rs.getString("username"));
				r.setPassword(rs.getString("password"));
				r.setAuthority(rs.getString("authority"));
				r.setUserdata_id(rs.getString("userdata_id"));
				r.setCreate_date(rs.getDate("create_date"));
				r.setUpdate_date(rs.getDate("update_date"));
				r.setNote(rs.getString("note"));
				r.setTag(rs.getString("tag"));
			}

			ps.close();
			conn.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println(e.getMessage() + " : " + this.getClass().getName() + "::queryByID");
		}

		return r;
	}

}
