package test2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

import com.ilan.control.connection.MyConnection;
import com.ilan.control.dao.word.TestboxDao;
import com.ilan.model.word.Testbox;

public class TestboxDaoTest extends TestboxDao {

	@Override
	public boolean add(Testbox t) {
		Connection conn = MyConnection.getConnection();

		String sql = "insert into testbox (t_id,name,testtimes,testdate,"
				+ "cards,create_date,update_date,creator,note,tag) values(?,?,?,?,?,?,?,?,?,?)";
		int r = 0;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, t.getT_id());
			ps.setString(2, t.getName());
			ps.setInt(3, t.getTesttimes());
			ps.setTimestamp(4, t.getTestdate());
			ps.setString(5, t.getCards());
			ps.setDate(6, t.getCreate_date());
			ps.setDate(7, t.getUpdate_date());
			ps.setString(8, t.getCreator());
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
	
	@Test
	public void test() {
		testAdd();
	}

	// @Test
	public void testAdd() {
		Testbox box = new Testbox();
		box.setT_id("t126");
		box.setName("tb126");
		// String date=new SimpleDateFormat().format(new java.util.Date());
		// box.setTestdate(date);
		box.setCreate_date(new Date(new java.util.Date().getTime()));
		// box.setCreator("u123");

		TestboxDaoTest dao = new TestboxDaoTest();
		System.out.println("add:" + dao.add(box));

	}

}
