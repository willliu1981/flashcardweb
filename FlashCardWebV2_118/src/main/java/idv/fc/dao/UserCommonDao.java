package idv.fc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import idv.fc.dao.abs.CommonDao;
import idv.fc.model.User;

public class UserCommonDao extends CommonDao<User> {
	private UserCommonDao() {
		super(User.class);
	}

	@Override
	protected void createModelForQuery(ResultSet rs, User model) throws SQLException {
		model.setId(rs.getString("id"));
		model.setUsername(rs.getString("username"));
		model.setPassword(rs.getString("password"));
		model.setDsiplay_name(rs.getString("display_name"));
		model.setGender(rs.getInt("gender"));
		model.setAuthority(rs.getString("authority"));
		model.setCreate_date(rs.getDate("create_date"));
		model.setTag(rs.getString("tag"));
	}

	@Override
	protected void createMapForCreate(Map<String, Object> cols, User model) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createMapForUpdate(Map<String, Object> cols, User model) {
		// TODO Auto-generated method stub

	}
	/*
		@Override
		public void create(User t) {
			String sql = "insert into user (id,username,password,diplay_name,create_date)"
					+ " values (?,?,?,?,?)";
	
			Connection conn = this.getConnection();
			try {
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, t.getId().trim());
				st.setString(2, t.getUsername().trim());
				st.setString(3, t.getPassword().trim());
				st.setString(4, t.getDsiplay_name().trim());
				st.setDate(5, t.getCreate_date());
	
				st.execute();
	
				this.closeResources(st, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
		}
	
		@Override
		public void update(User t, Object id) {
			String sql = "update user password=?,diplay_name=?,gender=?,age=?"
					+ ",tag=? where id=?";
	
			Connection conn = this.getConnection();
			try {
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, t.getPassword().trim());
				st.setString(2, t.getDsiplay_name().trim());
				st.setInt(3, t.getGender());
				st.setInt(4, t.getAge());
				st.setString(5, t.getTag());
				st.setString(6, id.toString());
	
				st.execute();
	
				this.closeResources(st, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
		}
	
		@Override
		public User queryById(Object id) {
			String sql = "select * from user where id=?";
	
			Connection conn = this.getConnection();
			User model = null;
			try {
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, id.toString());
				ResultSet rs = st.executeQuery();
				if (rs.next()) {
					model = new Vocabulary();
					model.setId(rs.getString("vid"));
					model.setVocabulary(rs.getString("vocabulary"));
					model.setTranslation(rs.getString("translation"));
					model.setCreate_date(rs.getDate("create_date"));
					model.setTag(rs.getString("tag"));
				}
				this.closeResources(rs, st, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
			return model;
		}
	 
		@Override
		public List<User> queryAll() {
			String sql = "select * from vocabulary ";
	
			Connection conn = this.getConnection();
			List<User> list = new ArrayList<>();
			try {
				PreparedStatement st = conn.prepareStatement(sql);
				ResultSet rs = st.executeQuery();
				Vocabulary model = null;
				while (rs.next()) {
					model = new Vocabulary();
					model.setId(rs.getString("vid"));
					model.setVocabulary(rs.getString("vocabulary"));
					model.setTranslation(rs.getString("translation"));
					model.setCreate_date(rs.getDate("create_date"));
					model.setTag(rs.getString("tag"));
					list.add(model);
				}
	
				this.closeResources(rs, st, conn);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
			return list;
		}
	//*/
}
