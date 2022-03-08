package idv.fc.model.proxy;

import java.sql.Date;

public interface IVocabulary {

	String getTag();

	void setTag(String tag);

	String getVid();

	void setVid(String vid);

	String getVocabulary();

	void setVocabulary(String vocabulary);

	String getTranslation();

	void setTranslation(String translation);

	Date getCreate_date();

	void setCreate_date(Date create_date);

}