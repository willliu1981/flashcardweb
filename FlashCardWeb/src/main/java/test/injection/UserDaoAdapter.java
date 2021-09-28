package test.injection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.flashcard.dao.user.IUserDao;
import com.flashcard.exception.ResultNullException;
import com.flashcard.factory.BeanFactory;
import com.flashcard.model.user.User;

public class UserDaoAdapter implements IUserDao<User> {
	protected DataSource dataSource = BeanFactory.getBean("dataSource",
			DataSource.class);
	
	
	private MenuDocument doc=new MenuDocument();


	@Override
	public void setDataSource(DataSource dataSource) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean add(User t) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User queryByID(String idSegment) throws IOException, SQLException {
		User user = find("select * from user where u_id=?", idSegment);
		if (user == null) {
			throw new ResultNullException("Result is Null:"
					+ this.getClass().getName() + "::queryByID:" + idSegment);
		}
		return user;
	}

	@Override
	public List<User> queryAll() throws SQLException, ResultNullException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(String id, User t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User find(String sqlSegment, String... querys)
			throws ResultNullException, SQLException {
		Connection conn = null;
		User r = null;
		try {
			PreparedStatement ps = (conn = dataSource.getConnection())
					.prepareStatement(sqlSegment);
			for (int idx = 0; idx < querys.length; idx++) {
				ps.setString(idx + 1, querys[idx]);
			}

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
			System.out.println(e.getMessage() + " : "
					+ this.getClass().getName() + "::find:" + sqlSegment);
		}

		return r;
	}

	@Override
	public User identifyUser(String username, String password)
			throws ResultNullException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByUsername(String username)
			throws ResultNullException, SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
