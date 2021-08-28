package com.ilan.control.dao.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.ilan.control.connection.MyConnection;
import com.ilan.control.dao.Dao;
import com.ilan.model.user.User;
import com.ilan.model.user.Userdata;

public class UserdataDao implements Dao<Userdata> {

	@Override
	public boolean add(Userdata t) {
		Connection conn = MyConnection.getConnection();

		String sql = "insert into userdata (ud_id,user_id,name,email,cardboxdata,scenedata,"
				+ "create_date,update_date,note,tag) values(?,?,?,?,?,?,?,?,?,?)";
		int r = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getUd_id());
			ps.setString(2, t.getUser_id());
			ps.setString(3, t.getName());
			ps.setString(4, t.getEmail());
			ps.setString(5, t.getCardboxdata());
			ps.setString(6, t.getScenedata());
			ps.setDate(7, t.getCreate_date());
			ps.setDate(8, t.getUpdate_date());
			ps.setString(9, t.getNote());
			ps.setString(10, t.getTag());

			r = ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (SQLException e) {
			// e.printStackTrace();
			System.out.println(e.getMessage() + " : " + this.getClass().getName() + "::add");
		}

		return r > 0 ? true : false;
	}

	@Override
	public Userdata queryByID(String id) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Userdata> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(String id, Userdata t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Test
	public void test() {
		testAdd();
	}

	// @Test
	public void testAdd() {
		Userdata data = new Userdata();
		data.setUd_id("ud256");
		data.setUser_id("u123");

		UserdataDao dao = new UserdataDao();
		System.out.println("add:" + dao.add(data));

	}

}
