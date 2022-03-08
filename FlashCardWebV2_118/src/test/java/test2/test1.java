package test2;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import idv.fc.dao.abs.BaseDao2;
import idv.fc.model.Vocabulary;

public class test1 {

	public static void main(String[] args) {
		BaseDao2<Vocabulary> bd = new BaseDao2<Vocabulary>() {

			@Override
			public void update(Vocabulary model, Object id) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void createMapForCreateOrUpdate(Vocabulary model,
					Map<String, Object> cols) {
				cols.put("id", model.getId());
				cols.put("vocabulary", model.getVocabulary());
				cols.put("translation", model.getTranslation());
				cols.put("create_date", model.getCreate_date());
				
			}

			@Override
			public Vocabulary createModelForQuery(ResultSet rs) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}



		};
		Vocabulary v = new Vocabulary();
		v.setVocabulary("xxx");
		System.out.println("ccc");
		bd.create(v);
	}

}
