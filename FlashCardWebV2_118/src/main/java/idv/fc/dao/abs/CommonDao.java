package idv.fc.dao.abs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import idv.fc.tool.StringConstructor;

public abstract class CommonDao<T> extends BaseDao<T> {
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

		String cols = StringConstructor.join(keyArr);

		String questionMarks = StringConstructor.join("%s?", keyArr, false);

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

		String fragment = StringConstructor.join("%s=?", keyArr);

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
}
