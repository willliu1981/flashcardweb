package idv.fc.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;

import idv.fc.dao.abstraction.CommonDao;
import idv.fc.model.User;

public class UserCommonDao extends CommonDao<User> {
	protected UserCommonDao() {
		super(User.class);
	}

	@Override
	protected void createModelForQuery(ResultSet rs, User model) throws SQLException {
		model.setId(rs.getString("id"));
		model.setUsername(rs.getString("username"));
		model.setPassword(rs.getString("password"));
		model.setDisplay_name(rs.getString("display_name"));
		model.setGender(rs.getInt("gender"));
		model.setAge(rs.getInt("age"));
		model.setAuth(rs.getString("auth"));
		model.setCreate_date(rs.getDate("create_date"));
		model.setTag(rs.getString("tag"));
	}

	@Override
	protected void createMapForCreate(Map<String, Object> cols, User model) {
		cols.put("id", "u_" + model.getUsername().trim());
		cols.put("display_name", model.getDisplay_name().trim());
		cols.put("username", model.getUsername().trim());
		cols.put("password", model.getPassword().trim());
		cols.put("age", model.getAge());
		cols.put("gender", model.getGender());
		cols.put("create_date", Date.valueOf(LocalDate.now()));

	}

	@Override
	protected void createMapForUpdate(Map<String, Object> cols, User model) {
		cols.put("display_name", model.getDisplay_name().trim());
		cols.put("password", model.getPassword().trim());
		cols.put("age", model.getAge());
		cols.put("gender", model.getGender());
		cols.put("auth", model.getAuth());

	}

}
