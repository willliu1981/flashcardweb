package idv.fc.pojo;

import java.sql.Date;

public class Vocabulary {
	private String id;// {pk,not null,unique}
	private String vocabulary;// not null, unique
	private String translation;// not null
	private Date createDate;// not null
	private String tag;

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getId() {
		return id;
	}

	public void setId(String vid) {
		this.id = vid;
	}

	public String getVocabulary() {
		return vocabulary;
	}

	public void setVocabulary(String vocabulary) {
		this.vocabulary = vocabulary;
	}

	public String getTranslation() {
		return translation;
	}

	public void setTranslation(String translation) {
		this.translation = translation;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date create_date) {
		this.createDate = create_date;
	}

	@Override
	public String toString() {
		return "Vocabulary [id=" + id + ", vocabulary=" + vocabulary + ", translation="
				+ translation + ", create_date=" + createDate + ", tag=" + tag + "]";
	}

}
