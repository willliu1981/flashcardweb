package idv.fc.dao.abs;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import idv.fc.tool.StringJoiner;

public abstract class CommonDao<T> extends BaseDao<T> {
	@Autowired
	@Qualifier("JDBCStringJoiner")
	StringJoiner stringConstructor;
	private String tableName;

	protected CommonDao() {
		this.tableName = getGenericTypeSuperClassName().toLowerCase();
	}

	/**
	 * 取得泛型除了 Object 類別的最上層類別名稱
	 * @return
	 */
	protected String getGenericTypeSuperClassName() {
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		Type[] type = pt.getActualTypeArguments();
		Class<?> clazz = (Class<?>) type[0];

		Deque<String> names = new LinkedList<>();

		do {
			names.offerFirst(clazz.getSimpleName());
			if (names.size() > 2) {
				names.pollLast();
			}

		} while ((clazz = clazz.getSuperclass()) != null);

		if (names.peekLast().equalsIgnoreCase("object")) {
			return names.peekFirst();
		} else {
			return names.peekLast();
		}
	}

	protected String getTableName() {
		return tableName;
	}

	public void setTableName(String name) {
		this.tableName = name;
	}

	protected StringJoiner getStringConstructor() {
		return stringConstructor;
	}

	@Override
	public void create(T model) {
		Map<String, Object> map = new HashMap<>();
		this.createMapForCreate(model, map);

		List<String> keys = new ArrayList<>();
		List<Object> values = new ArrayList<>();

		map.forEach((k, v) -> {
			keys.add(k);
			values.add(v);
		});

		String[] keyArr = keys.toArray(new String[keys.size()]);
		Object[] valueArr = values.toArray(new Object[values.size()]);

		String cols = getStringConstructor().join(keyArr);

		String questionMarks = getStringConstructor().join("%s?", keyArr, false);

		String sql = String.format("insert into %s (%s) values (%s)",
				this.getTableName(), cols, questionMarks);

		this.executeSQL(sql, valueArr);
	}

	@Override
	public void update(T model, Object id) {
		Map<String, Object> map = new HashMap<>();
		this.createMapForCreate(model, map);

		List<String> keys = new ArrayList<>();
		List<Object> values = new ArrayList<>();

		map.forEach((k, v) -> {
			keys.add(k);
			values.add(v);
		});

		// sql : where id=? 將id 追加到最後一個元素
		values.add(id);

		String[] keyArr = keys.toArray(new String[keys.size()]);
		Object[] valueArr = values.toArray(new Object[values.size()]);

		String fragment = getStringConstructor().join("%s=?", keyArr);

		String sql = String.format("update %s set %s where id=?", this.getTableName(),
				fragment);

		this.executeSQL(sql, valueArr);
	}

	@Override
	public void delete(Object id) {
		String sql = String.format("delete from  %s where id=?", this.getTableName());
		this.deleteSQL(id, sql);
	}

	@Override
	public T queryById(Object id) {
		String sql = String.format("select * from %s where id=?", this.getTableName(),
				id);
		return querySQL(sql, id).get(0);
	}

	@Override
	public List<T> queryAll() {
		String sql = String.format("select * from %s", this.getTableName());
		return querySQL(sql);
	}

	public List<T> querySQL(String sql) {
		return querySQL(sql, null);
	}

	public List<T> querySQL(String sql, Object id) {
		Connection conn = this.getConnection();
		List<T> list = new ArrayList<>();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			if (id != null) {
				st.setObject(1, id);
			}
			ResultSet rs = st.executeQuery();
			T model = null;
			while (rs.next()) {
				model = this.createModelForQuery(rs);
				list.add(model);
			}

			this.closeResources(rs, st, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	protected abstract T createModelForQuery(ResultSet rs) throws SQLException;

	protected abstract void createMapForCreate(T model, Map<String, Object> cols);

	protected abstract void createMapForUpdate(T model, Map<String, Object> cols);
}