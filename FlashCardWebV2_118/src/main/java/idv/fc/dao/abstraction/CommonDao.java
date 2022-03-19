package idv.fc.dao.abstraction;

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

import idv.fc.exception.FindErrorException;
import idv.fc.tool.StringJoiner;

/**
 * 實作類必須填寫T型別,或者空參數建構子,否則使用SQL query 可能會報錯
 * 當table 名稱與 對應的類別名稱不同時,須於 -servlet.xml 加入屬性 tableName 
 * 如果T型別(除了 Object)不是最上層型別, 須加入建構子,並以 T 的實際類別當作參數傳入 
 * @author KuanWei
 *
 * @param <T>
 */
public abstract class CommonDao<T> extends BaseDao<T> {
	@Autowired
	@Qualifier("JDBCStringJoiner")
	StringJoiner stringJoiner;
	private String tableName;
	private Class<T> clazz;

	protected CommonDao(Class<T> classNameForTable) {
		this.clazz = classNameForTable;
		this.tableName = this.clazz.getSimpleName().toLowerCase();
	}

	protected CommonDao() {
		this.clazz = getGenericTypeSuperClass();
		this.tableName = clazz.getSimpleName().toLowerCase();
	}

	/**
	 * 取得泛型除了 Object 類別的最上層類別型別
	 * 
	 * @return
	 */
	protected Class<T> getGenericTypeSuperClass() {
		ParameterizedType pt = (ParameterizedType) this.getClass()
				.getGenericSuperclass();
		Type[] type = pt.getActualTypeArguments();
		Class<T> clazz = (Class<T>) type[0];

		Deque<Class<T>> classes = new LinkedList<>();

		do {
			classes.offerFirst(clazz);
			if (classes.size() > 2) {
				classes.pollLast();
			}

		} while ((clazz = (Class<T>) clazz.getSuperclass()) != null);

		if (classes.peekLast() == Object.class) {
			return classes.peekFirst();
		} else {
			return classes.peekLast();
		}
	}

	protected String getTableName() {
		return tableName;
	}

	public void setTableName(String name) {
		this.tableName = name;
	}

	protected StringJoiner getStringJoiner() {
		return stringJoiner;
	}

	@Override
	public void create(T model) throws SQLException {
		Map<String, Object> map = new HashMap<>();
		this.createMapForCreate(map, model);

		List<String> keys = new ArrayList<>();
		List<Object> values = new ArrayList<>();

		map.forEach((k, v) -> {
			keys.add(k);
			values.add(v);
		});

		String[] keyArr = keys.toArray(new String[keys.size()]);
		Object[] valueArr = values.toArray(new Object[values.size()]);

		String cols = getStringJoiner().join(keyArr);

		String questionMarks = getStringJoiner().join("%s?", keyArr, false);

		String sql = String.format("insert into %s (%s) values (%s)",
				this.getTableName(), cols, questionMarks);
		this.executeSQL(sql, valueArr);
	}

	@Override
	public void update(T model, Object id) throws SQLException {
		Map<String, Object> map = new HashMap<>();
		this.createMapForCreate(map, model);

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

		String columnFragment = getStringJoiner().join("%s=?", keyArr);

		String sql = String.format("update %s set %s where id=?", this.getTableName(),
				columnFragment);

		this.executeSQL(sql, valueArr);
	}

	@Override
	public void delete(Object id) {
		String sql = String.format("delete from  %s where id=?", this.getTableName());
		this.deleteSQL(sql, id);
	}

	@Override
	public T queryById(Object id) throws FindErrorException {
		String sql = String.format("select * from %s where id=?", this.getTableName(),
				id);
		List<T> res = querySQL(sql, id);
		if (res.isEmpty()) {
			throw new FindErrorException(this.getClass() + ":" + id);
		}
		return res.get(0);
	}

	@Override
	public List<T> queryAll() {
		String sql = String.format("select * from %s", this.getTableName());
		return querySQL(sql);
	}

	public List<T> querySQL(String sql) {
		return querySQL(sql, null);
	}

	public List<T> querySQL(String sql, Object... params) {
		Connection conn = this.getConnection();
		List<T> list = new ArrayList<>();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(sql);
			prepareStatementSetObjects(st, params);
			rs = st.executeQuery();
			T model = null;
			while (rs.next()) {
				model = this.clazz.newInstance();
				this.createModelForQuery(rs, model);
				list.add(model);
			}

			this.closeResources(rs, null, conn);
		} catch (SQLException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}

		return list;
	}

	protected abstract void createModelForQuery(ResultSet rs, T model)
			throws SQLException;

	protected abstract void createMapForCreate(Map<String, Object> cols, T model);

	protected abstract void createMapForUpdate(Map<String, Object> cols, T model);
}